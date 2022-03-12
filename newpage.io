# excu01
<!DOCTYPE html>
<html lang = ko>
<head>
<meta charset="UTF-8">
<title>** Join Us **</title>
<style>
body {
background-image : url("roomred.jpg");
width: 500px;
margin: 30px auto;
}
.menu-trigger {
margin-right: 70px;
margin-bottom: 50px;
float : right;
}
.menu-trigger,
.menu-trigger span {
display: inline-block;
transition: all .4s;
box-sizing: border-box;
}

.menu-trigger {
position: relative;
width: 50px;
height: 44px;
}

.menu-trigger span {
position: absolute;
left: 0;
width: 100%;
height: 4px;
background-color: #fff;
border-radius: 4px;
}

.menu-trigger span:nth-of-type(1) {
top: 0;
}

.menu-trigger span:nth-of-type(2) {
top: 20px;
}

.menu-trigger span:nth-of-type(3) {
bottom: 0;
}
.menu-trigger.active-10 {
-webkit-transform : rotate(90deg);
transform : rotate(90deg);

}
</style>
<script>
var burger = $('.menu-trigger');

burger.each(function(index){
var $this = $(this);

$this.on('click', function(e){
e.preventDefault(); 
$(this).toggleClass('active-' + (index+1));
})
});
</script>
</head>
<body>
<header>
</header>
<nav>
<a class="menu-trigger" href="#">
<span></span>
<span></span>
<span></span>
</a>
</nav>
</body>
</html>
