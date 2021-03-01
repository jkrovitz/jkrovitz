<head> 
	<?php include('connect_db.php');?>
	<title>Convert Temperature</title> 
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js">
  </script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
  </script>
  <?php include 'favicons.php';?>

  <link href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/3.7.95/css/materialdesignicons.css" rel="stylesheet">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
      <link href="../style/matt_style.css" rel="stylesheet">
  <link href="../style/style.css" rel="stylesheet">
    <script src="../script.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- Jquery cdn -->
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	 <style>

  .quote {
  background: #ddd;
  position: relative;
  z-index: 1;
}
.quote:before, .quote:after {
  background: inherit;
  content: '';
  display: block;
  height: 50%;
  left: 0;
  position: absolute;
  right: 0;
  z-index: -1;
  -webkit-backface-visibility: hidden;
}
.quote:before {
  top: 0;
  -webkit-transform: skewY(1.5deg);
          transform: skewY(1.5deg);
  -webkit-transform-origin: 100% 0;
          transform-origin: 100% 0;
}
.quote:after {
  bottom: 0;
  -webkit-transform: skewY(-1.5deg);
          transform: skewY(-1.5deg);
  -webkit-transform-origin: 100%;
          transform-origin: 100%;
}

.quote {
  color: #fff;
  margin: 6rem 0;
  padding: 10% 10px;
  text-align: center;
}

h1 {
  font-size: 32px;
  font-weight: 500;
}

p {
  font-size: 14px;
  font-weight: 300;
  margin-top: 0.5em;
}

  body{
    background-color: #fff !important;
  }

  h1{
    font-size: 3.5rem !important;
  }




  .top-capstone-card{
    border-top: #01426a solid  0.0625rem !important;
    background-color: #71c5e8 !important;
    margin-top: -1rem !important;
    border-radius: 0px !important;
    border-right: none !important;
    border-bottom: #01426a solid  0.0625rem !important;
    border-left: none !important;
  }

  .bottom-capstone-card{
    border: solid 3px #01426a !important;
  }

  .jumbotron{
    background-color: #01426a !important;
    color: white !important;
  }

  .header-link{
    text-decoration: none;
    color: white;
  }
  .header-link:hover{
    text-decoration: none;
    color: white;
  }

  h2, h3, h4{
    text-align: center;
    color: #01426a;
  }

  h4{
    font-size: 1.25rem !important;
  }

  @media screen and (min-width: 600px){
    h3{
      font-size: 1.5rem !important;
    }
  }

  @media screen and (max-width: 600px){
    h3{
      font-size: 1.4rem !important;
    }
  }

  p{
    color: #01426a;
  }

  /* .card-img{
    border-radius: 5px;
  } */

  .breadcrumb-id{
    color: #01426a !important;
  }

  .breadcrumb {
    background-color: rgba(255, 255, 255, 0) !important;
  }

  .active-b-i{
    color: #01426a !important;
  }

  .arr-right .breadcrumb-item+.breadcrumb-item::before {
    content: "›";
    vertical-align:top;
    color: #01426a;
    font-size:30px;
    line-height:18px;

  }

  .padding-around-card-content{
    padding: 80px;
  }

  </style>
</head> 
<body> 

  <!--<div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0">-->
  <!--  <h1 class="pt-5"><a class="header-link" href="index.html">Jeremy Krovitz</a></h1>-->
  <!--</div>-->
  <nav class="navbar navbar-expand-md navbar-dark fixed-top">
    <a class="navbar-brand" href="../index.php">Jeremy Krovitz</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="../index.php#home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../index.php#about">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../index.php#software-projects">Software Projects</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../index.php#gis-projects">GIS Projects</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../index.php#contact">Contact</a>
      </li>

    </ul>
  </div>
  </nav>


  <nav aria-label="breadcrumb" id="breadcrumb-id">
    <ol class="breadcrumb arr-right">
      <li class="breadcrumb-item">
        <a href="../index.php">Home</a>
      </li>
      <li class="breadcrumb-item active-b-i">Temperature Conversion Worksheet Question Form</li>
    </ol>
  </nav>
	<h2>Temperature Conversion</h2> 
	<form class="m-5" action = "<?php echo $_SERVER['PHP_SELF']; ?>" method = "GET"> 
		<div class="form-group">
			<label>Degrees: </label>
			<input class="form-control" type = "text" name = "degree" size=4 value="">
		</div>

		<div class="form-group">
			<label>Select Input Unit</label>
			<select class="form-control"name="scale"> <option value="celsius">Celsius</option> <option value="fahrenheit">Fahrenheit</option> <option value="kelvin">Kelvin</option> <option value="rankine">Rankine</option> </select> 
		</div>
		<div class="form-group">
			<label> Select target unit</label>
			<select class="form-control" name="scale2"> <option value="celsius">Celsius</option> <option value="fahrenheit">Fahrenheit</option> <option value="kelvin">Kelvin</option> <option value="rankine">Rankine</option> </select> 
		</div>
		<div class="form-group">
			<label>Student Response</label>
			<input type = "text" name="studentResponse" class="form-control" size=4> 
		</div>
		<br/>
		<div class="text-center"> 
			<input type = "submit" class="btn btn-primary" name="Convert Temperature"/> 
		</div>
	</form> 

	<?php 
 //check for input
	if (array_key_exists('degree',$_GET) && array_key_exists('studentResponse', $_GET)){
		$scale = $_GET['scale'];
		$scale2 = $_GET['scale2'];
		$degree = $_GET['degree'];
		$studentResponse = $_GET['studentResponse'];
		$studentResponseRounded = round($studentResponse,0); 
		$firstLength = strlen($_GET['degree']);

		if(($firstLength > 0) && (is_numeric($_GET['degree'])))
		{
			if ($scale == "celsius" && $scale2 == "celsius") 
			{
				$c_2_c = round($degree);
				handleIfStatements($degree, $scale, $scale2, $c_2_c, $studentResponseRounded); 

			} 
			if ($scale == "celsius" && $scale2 == "kelvin") 
			{

				$c_2_k = round($degree+273.15,0); 
				handleIfStatements($degree, $scale, $scale2, $c_2_k, $studentResponseRounded); 
			} 
			if ($scale == "celsius" && $scale2 == "fahrenheit") 
			{

				$f_2_k = round($degree+273.15,0); 
				handleIfStatements($degree, $scale, $scale2, $f_2_k, $studentResponseRounded); 
			}
			if ($scale == "celsius" && $scale2 == "rankine"){
				$c_2_r = round(($degree+273.15)*9/5,0); 
				handleIfStatements($degree, $scale, $scale2, $c_2_r, $studentResponseRounded); 
			}
			if ($scale == "fahrenheit" && $scale2 == "fahrenheit") {
				$f_2_f = round($degree);
				handleIfStatements($degree, $scale, $scale2, $f_2_f, $studentResponseRounded); 

			} 
			if ($scale == "fahrenheit" && $scale2 == "kelvin"){
				$f_2_k = round($f_2_c+273.15); 
				handleIfStatements($degree, $scale, $scale2, $f_2_k, $studentResponseRounded); 
			} 
			if ($scale == "fahrenheit" && $scale2 == "celsius"){
				$f_2_c = round(($degree -32)*5/9); 
				handleIfStatements($degree, $scale, $scale2, $f_2_c, $studentResponseRounded); 
			}
			if ($scale == "fahrenheit" && $scale2 == "rankine"){
				$f_2_r = round($degree+459.6 ); 
				handleIfStatements($degree, $scale, $scale2, $f_2_r, $studentResponseRounded); 
			}
			if ($scale == "kelvin" && $scale2 == "kelvin"){
				$k_2_k = round($degree);
				handleIfStatements($degree, $scale, $scale2, $k_2_k, $studentResponseRounded); 

			} 
			if ($scale == "kelvin" && $scale2 == "celsius"){
				$k_2_c = round($degree-273.15); 
				handleIfStatements($degree, $scale, $scale2, $k_2_c, $studentResponseRounded); 
			} 
			if ($scale == "kelvin" && $scale2 == "fahrenheit"){
				$k_2_f = round(($degree - 273.15) * 9 / 5 + 32); 
				handleIfStatements($degree, $scale, $scale2, $k_2_f, $studentResponseRounded); 
			}
			if ($scale == "kelvin" && $scale2 == "rankine"){
				$k_2_r = round((($degree - 273.15) * 9 / 5 + 32)+459.6); 
				handleIfStatements($degree, $scale, $scale2, $k_2_r, $studentResponseRounded); 
			}
			if ($scale == "rankine" && $scale2 == "rankine"){
				$r_2_r = round($degree);
				handleIfStatements($degree, $scale, $scale2, $r_2_r, $studentResponseRounded); 
			} 
			if ($scale == "rankine" && $scale2 == "fahrenheit"){
				$r_2_f = round($degree-459.6); 
				handleIfStatements($degree, $scale, $scale2, $r_2_f, $studentResponseRounded); 
			} 
			if ($scale == "rankine" && $scale2 == "celsius"){
				$r_2_c = round(($degree-459.6 - 32)*5/9); 
				handleIfStatements($degree, $scale, $scale2, $r_2_c, $studentResponseRounded); 
			}
			if ($scale == "rankine" && $scale2 == "kelvin"){
				$r_2_k = round((($degree-459.6 - 32)*5/9) + 273.15); 
				handleIfStatements($degree, $scale, $scale2, $r_2_k, $studentResponseRounded); 
			}
		}else
		//print invalid if the input temperature is not of data type float 
			echo "<span class='m-5' style = \"color:red\">Invalid</span>";
	}
	?> 
	<?php 
	function handleIfStatements($degree, $scale ,$scale2, $unit_2_unit, $studentResponseRounded){
		if($unit_2_unit != $studentResponseRounded){
			print"<table class='m-5 table table-bordered'><tr>
			<td>$degree</td>
			<td>$scale</td>
			<td>$scale2</td>
			<td>$studentResponseRounded</td>
			<td>Incorrect</td>
			</tr></table>";
		}
		if($unit_2_unit == $studentResponseRounded){
			print"<table class='m-5 table table-bordered'>
			<tr>
			<td>$degree</td>
			<td>$scale</td>
			<td>$scale2</td>
			<td>$studentResponseRounded</td>
			<td>Correct</td>
			</tr></table>";
		}
	}
	?>
	
	
	<?php include('../footer.php')?>
	</body>
	</html>