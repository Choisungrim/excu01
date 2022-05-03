const age = parseInt(prompt("How old are you?"))

if(isNaN(age) || age<0){ // age의 타입이 number 가 아니면 true를 리턴
    console.log ("please write a real positive number");
}else if((age < 18)){ // age의 타입이 number 이면 false를 리턴(중첩 if 문 실행)
    console.log("you are too young");
}else if(age >= 18 && age <= 50){
    console.log("your old 18~50");
}else if(age > 50 && age <= 80){
    console.log("you shoud exercise");
}else if(age === 100){
    console.log("wow you are wise");
}else if(age > 80){
    console.log("you can do whatever you want");
}
