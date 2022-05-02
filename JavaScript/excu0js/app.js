const title = document.querySelector(".hello:first-child h1");
count = 0;
function handleTitleClick(){
    console.log("Click");
   count += 1;
    if(!(count>10)){
        title.style.color ="red";
    }else{
        title.style.color = "blue";
    }
}
title.addEventListener("click",handleTitleClick);