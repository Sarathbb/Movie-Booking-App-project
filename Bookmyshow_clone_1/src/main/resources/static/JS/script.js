const seats = document.querySelector('.seat:not(.occupied)');
const container = document.querySelector('.container');
let seatAmount = 0.00;

let footerOne = document.querySelector('.footer-one');
let footerTwo = document.querySelector('.footer-two');
let amountBtn = document.querySelector('.amt');
let amount = document.getElementById("amount");
//let seat = document.getElementsByClassName('seats');
let dateAtt = document.getElementById("dateAtt");
const date = new Date();

let day = date.getDate();
let month = date.getMonth() + 1;
let year = date.getFullYear();
let currentDate = `${day}-${month}-${year}`;
console.log(currentDate);

function updatedSelectedCount(){
	const selectedSeat = document.querySelectorAll('.seat.selected');
	const selectedSeatCount = selectedSeat.length;
	console.log(selectedSeatCount);
	
	if(selectedSeatCount > 0){
		footerOne.classList.add('hidden');
		footerTwo.classList.remove('hidden');
		amount.setAttribute('value',seatAmount);
		dateAtt.setAttribute('value',currentDate);
		amountBtn.innerHTML = seatAmount.toFixed(2);
	}else{
		footerOne.classList.remove('hidden');
		footerTwo.classList.add('hidden');
	}
	
	
}


container.addEventListener('click',(e) => {
	if(e.target.classList.contains('seat') && !e.target.classList.contains('occupied'))
	{
		e.target.classList.toggle('selected');
		if(e.target.classList.contains('selected')){
			if(e.target.innerText.charAt(0) === 'A'){
				seatAmount += 335.00;
			}
			else if(e.target.innerText.charAt(0) === 'B'|| e.target.innerText.charAt(0) ==='C'|| e.target.innerText.charAt(0) ==='D'){
				seatAmount += 155.00;
			}
			else if(e.target.innerText.charAt(0) === 'E' || e.target.innerText.charAt(0) === 'F'||e.target.innerText.charAt(0) === 'G'
			        ||e.target.innerText.charAt(0) === 'H'||e.target.innerText.charAt(0) === 'I'||e.target.innerText.charAt(0) === 'J'
			        ||e.target.innerText.charAt(0) === 'K'||e.target.innerText.charAt(0) === 'L'||e.target.innerText.charAt(0) === 'M'
			        ||e.target.innerText.charAt(0) === 'N'){
				seatAmount += 129.00;
			}
			else if(e.target.innerText.charAt(0) === 'O'){
				seatAmount += 80.00;
			}
		}
		else if(e.target.classList.contains('seat')){
			if(e.target.innerText.charAt(0) === 'A'){
				seatAmount -= 335.00;
			}
			else if(e.target.innerText.charAt(0) === 'B'|| e.target.innerText.charAt(0) ==='C'|| e.target.innerText.charAt(0) ==='D'){
				seatAmount -= 155.00;
			}
			else if(e.target.innerText.charAt(0) === 'E' || e.target.innerText.charAt(0) === 'F'||e.target.innerText.charAt(0) === 'G'
			        ||e.target.innerText.charAt(0) === 'H'||e.target.innerText.charAt(0) === 'I'||e.target.innerText.charAt(0) === 'J'
			        ||e.target.innerText.charAt(0) === 'K'||e.target.innerText.charAt(0) === 'L'||e.target.innerText.charAt(0) === 'M'
			        ||e.target.innerText.charAt(0) === 'N'){
				seatAmount -= 129.00;
			}
			else if(e.target.innerText.charAt(0) === 'O'){
				seatAmount -= 80.00;
			}
		}
	}
	
	updatedSelectedCount();
})









