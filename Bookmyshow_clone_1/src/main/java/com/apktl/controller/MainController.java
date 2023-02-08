package com.apktl.controller;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.apktl.model.CurrentDateDTO;
import com.apktl.model.CustomerDTO;
import com.apktl.model.LoginDTO;
import com.apktl.model.MoviesDTO;
import com.apktl.model.Seat;
import com.apktl.model.TicketBookingDTO;
import com.apktl.service.CustomerService;
import com.apktl.service.DateService;
import com.apktl.service.MoviesService;
import com.apktl.service.SeatService;
import com.apktl.service.TicketBookingService;
import com.apktl.uploadhelper.FileUploadHelper;

@Controller
public class MainController {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private FileUploadHelper fHelper;
	
	@Autowired
	private MoviesService mService;
	
	@Autowired
	private DateService dServ;
	
	@Autowired
	private TicketBookingService tService;
	
	@Autowired
	private SeatService sServ;
	
	private CustomerDTO custDTO;
	private CustomerDTO cDto;
	
	@GetMapping("/home")
	public String bootStrapEx(Model model,HttpSession sess) {
		
		CustomerDTO cDto = new CustomerDTO();
		model.addAttribute("users", cDto);
		model.addAttribute("passw", sess.getAttribute("passw"));
		sess.invalidate();
		return "home";
	}
	
	@PostMapping("/home/signup")
	public String addUser(CustomerDTO cdto) {
		
		service.addCustomer(cdto);
		
		return "redirect:/home";
	}
	
	@PostMapping("/home/login")
	public String checkLogin(LoginDTO lDto,HttpServletRequest req,HttpSession sess,RedirectAttributes ra,Model m) {
		
		String email = req.getParameter("logEmail");
		String pass = req.getParameter("logPassword");
		
		cDto = service.findByEmail(email);
		//sess.setAttribute("id", cDto.getId());
		if(cDto != null && cDto.getPassword().equals(pass))
		{
			
			sess.setAttribute("custName", cDto.getName());
			m.addAttribute("custName",cDto.getName());
			sess.setAttribute("customer", cDto);
			System.out.println(custDTO);
			return "redirect:/userhome";
		}
		if(email.equals("admin765@gmail.com") && pass.equals("admin@123"))
		{
			sess.setAttribute("custName", "Administrator");
			m.addAttribute("custName", "Administrator");
			return "redirect:/adminhome";
		}else {
			
			ra.addFlashAttribute("message", "Invalid Email And Password!! pls Try again!!!");
			
			return "redirect:/home";
		}
		
		
	}
	
	@PostMapping("/home/forgetpassword")
	public String forgetPasswordPage(HttpServletRequest req,HttpSession sess,RedirectAttributes ra) {
		
		String emailId = req.getParameter("emailid");
		CustomerDTO cuDto = service.findByEmail(emailId);
		if(cuDto != null) {
			sess.setAttribute("passw", cuDto.getPassword());
			System.out.println("Recover Pass is "+cuDto.getPassword().toString());
			return "redirect:/home";
		}else {
			ra.addFlashAttribute("message", "This email id not exist!! pls Try again!!!");
			return "redirect:/home";
		}
		
	}
	
	
	@GetMapping("/adminhome")
	public String adminHome(Model model) {
		
		Iterable<MoviesDTO> mdto = mService.getMovies();
		model.addAttribute("movies", mdto);
		model.addAttribute("custName", "Administrator");
		
		return "adminhome";
	}
	
	@GetMapping("/userhome")
	public String userHome(Model model,HttpSession sess) {
		
		Iterable<MoviesDTO> mdto = mService.getMovies();
		model.addAttribute("movies", mdto);
		//int id = Integer.parseInt((String) sess.getAttribute("id"));
		CustomerDTO cstmr = service.findById(cDto.getId());
		model.addAttribute("custName", cstmr.getName());
		model.addAttribute("user", cstmr);
		System.out.println("HOOO "+cDto);
		
        List<TicketBookingDTO> tbd = tService.getAllHistory(cstmr.getId());
		
		model.addAttribute("bookings", tbd);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();
		Date dt1 = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt1); 
		c.add(Calendar.DATE, 1);
		dt1 = c.getTime();
	    String dateString = dateFormat.format(dt);
	    String dateString1 = dateFormat.format(dt1);
	    model.addAttribute("todayDate", dateString);
	    model.addAttribute("myDate1", dateString1);
	    
	    
		
		return "userhome";
	}
	
	@GetMapping("/adminhome/addmovie")
	public String viewAddMoviePage() {
		return "adminaddmovie";
	}
	
	@GetMapping("/adminhome/editmovie/{mId}")
	public String viewEditMoviePage(@PathVariable("mId") int mId, Model model) {
		
		Optional<MoviesDTO> mdto = mService.getMovieById(mId);
		model.addAttribute("movies", mdto.get());
		
		return "admineditmovie";
	}
	
	@PostMapping("/adminhome/edit-savemovie")
	public String editMovie(@RequestParam("file") MultipartFile file,MoviesDTO mdto)
	{
		boolean bool = fHelper.uploadFile(file);
		if(bool) {
			mdto.setmImage(file.getOriginalFilename().toString());
			mService.saveMovies(mdto);
		}
		return "redirect:/adminhome";
	}
	
	@GetMapping("/adminhome/deletemovie/{mId}")
	public String deleteMovies(@PathVariable("mId") int mId)
	{
		mService.deleteMovies(mId);
		return "redirect:/adminhome";
	}
	
	@GetMapping("/adminhome/viewcustomers")
	public String viewAllCustomers(Model model)
	{
		List<CustomerDTO> cst = service.getAll();
		model.addAttribute("customers", cst);
		return "AdminViewCustomers";
	}
	
	@GetMapping("/adminhome/customer/viewbooking/{id}")
	public String customerViewBooking(@PathVariable("id") int id,Model model)
	{
		CustomerDTO cst = service.findById(id);
		model.addAttribute("name", cst.getName());
		List<TicketBookingDTO> tbd = tService.getAllHistory(id);
		
		model.addAttribute("bookings", tbd);
		return "AdminViewBookingHistory";
	}
	
	@PostMapping("/adminhome/upload-movies")
	public String uploadFile(@RequestParam("file") MultipartFile file,RedirectAttributes ra,MoviesDTO mdto){
		
		/*
		 * System.out.println(file.getOriginalFilename());
		 * System.out.println(file.getSize());
		 * System.out.println(file.getContentType());
		 * System.out.println(file.getName());
		 */
		
		if(file.isEmpty()) { 
			  ra.addFlashAttribute("message1","Please choose any Files");
			  return "adminaddmovie";
		}
		else if(!file.getContentType().equals("image/jpeg")) {
		      ra.addFlashAttribute("message2","Error!!Only JPEG files are allowed to Upload"); 
		      return "adminaddmovie";
		}
		else {
			boolean bool = fHelper.uploadFile(file);
			if(bool) {
				mdto.setmImage(file.getOriginalFilename().toString());
				mService.saveMovies(mdto);
				ra.addFlashAttribute("message3", "File Upload Successfully");
			}
			return "redirect:/adminhome";
		}
		
	}
	
	@GetMapping("/adminhome/viewmovies")
	public String viewMoviesListPage(Model model) {
		
		Iterable<MoviesDTO> mdto = mService.getMovies();
		model.addAttribute("movies", mdto);
		return "adminviewmovies";
	}
	
	@GetMapping("/userhome/{mId}")
	public String viewDateTimePage(@PathVariable("mId") int mId,Model m,HttpSession sess) {
		
		Optional<MoviesDTO> mdto = mService.getMovieById(mId);
		System.out.println("yes i am here");
		
		m.addAttribute("movi", mdto.get());
		m.addAttribute("movies", mdto.get().getmName());
		m.addAttribute("movieId", mId);
		m.addAttribute("mov", mdto.get().getLanguage());
		m.addAttribute("custName", sess.getAttribute("custName"));
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();
		String dtF = dateFormat.format(dt);
		m.addAttribute("todayDate", dtF);
		int checkDate = Integer.parseInt(dtF.substring(0, 2));
		m.addAttribute("checkDate",checkDate );
		
		Date dt1 = new Date();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		dt1 = c.getTime();
	    String dtf1 = dateFormat.format(dt1);
	    int hour = c.get(Calendar.HOUR_OF_DAY);
	    int date = c.get(Calendar.DATE);
	    
	    m.addAttribute("hour", hour);
	    m.addAttribute("date", date);
	    m.addAttribute("tomarrowDate", dtf1);
		
		return "userdatetime";
	}
	
	@GetMapping("/userhome/{mId}/tomarrow")
	public String viewDateTimeTmrwPage(@PathVariable("mId") int mId,Model m,HttpSession sess) {
		
		m.addAttribute("custName", sess.getAttribute("custName"));
		
		Optional<MoviesDTO> mdto = mService.getMovieById(mId);
		
		m.addAttribute("movi", mdto.get());
		m.addAttribute("movies", mdto.get().getmName());
		m.addAttribute("movieId", mId);
		m.addAttribute("mov", mdto.get().getLanguage());
		m.addAttribute("custName", sess.getAttribute("custName"));
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();
		String dtF = dateFormat.format(dt);
		m.addAttribute("todayDate", dtF);
		int checkDate = Integer.parseInt(dtF.substring(0, 2));
		m.addAttribute("checkDate",checkDate );
		
		Date dt1 = new Date();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		dt1 = c.getTime();
	    String dtf1 = dateFormat.format(dt1);
	    int hour = c.get(Calendar.HOUR);
	    int date = c.get(Calendar.DATE);
	    
	    m.addAttribute("hour", hour);
	    m.addAttribute("date", date);
	    m.addAttribute("tomarrowDate", dtf1);
		
		return "userdatetimetmrw";
	}
	
	@PostMapping("/userhome/seatlayout/{movieId}")
	public String viewSeatLayout(CurrentDateDTO cdate,HttpSession sess,Model m,@PathVariable("movieId") int movieId) {
		
		dServ.saveDateTime(cdate);
		
		Optional<MoviesDTO> mdto = mService.getMovieById(movieId);
		m.addAttribute("mName", mdto.get().getmName());
		m.addAttribute("date", cdate.getDate());
		m.addAttribute("time", cdate.getTime().toUpperCase());
		
		List<String> seatNo = tService.checkBookingSeats(mdto.get().getmName(),cdate.getDate(), cdate.getTime());
		System.out.println("HeHeHeHe-----"+seatNo);
		m.addAttribute("seats", seatNo);
		return "seatlayout";
	}
	
	@PostMapping("/userhome/bookseat")
	public String doneSeatBooking(TicketBookingDTO tdto,HttpSession sess,RedirectAttributes ra,Model m) {
		
		
		
		
		Seat seat = new Seat();
		
		
		seat.setSeatNo(tdto.getSeatNo());
		seat.setTotal(tdto.getTotalPrice());
		CustomerDTO cust = (CustomerDTO) sess.getAttribute("customer");
		
		int i = sServ.saveSeat(seat, cust, tdto.getMovieDate(), tdto.getMovieTime());
		tService.saveBookingData(tdto,cust);
		
		if(i > 0)
		{
			ra.addFlashAttribute("succBookingMsg", "Your Booking is Successfully Done");
			
		}
		return "redirect:/userhome";
	}
	@PostMapping("/userhome/edituser")
	public String editUser(@ModelAttribute CustomerDTO cust,Model model) {
		
		//System.out.println(cust);
		service.addCustomer(cust);
		
		model.addAttribute("custName", cust.getName());
		
		return "redirect:/userhome";
	}
	
	
}




