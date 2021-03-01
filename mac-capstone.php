<!DOCTYPE html>
<html lang="en">
<head>
  <title>Jeremy Krovitz Capstone Project</title>
  <meta charset="utf-8">
  <meta name=”theme-color” content=”#ffffff”>
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
      <link href="style/matt_style.css" rel="stylesheet">
  <link href="style/style.css" rel="stylesheet">
    <script src="script.js"></script>
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
<body lang="en">
    <script type="text/javascript">
var _userway_config = {
account: 'XmPrvhFSko'
};
</script>
<script type="text/javascript" src="https://usrwy.com/widget.js"></script>
  <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0">
    <h1 class="pt-5"><a class="header-link" href="index.html">Jeremy Krovitz</a></h1>
  </div>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top">
    <a class="navbar-brand" href="index.php">Jeremy Krovitz</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="index.php#home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="index.php#about">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="index.php#software-projects">Software Projects</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="index.php#gis-projects">GIS Projects</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="index.php#contact">Contact</a>
      </li>

    </ul>
  </div>
  </nav>


  <nav aria-label="breadcrumb" id="breadcrumb-id">
    <ol class="breadcrumb arr-right">
      <li class="breadcrumb-item">
        <a href="index.php">Home</a>
      </li>
      <li class="breadcrumb-item active-b-i">Capstone Presentation</li>
    </ol>
  </nav>
  <div>
    <div class="top-capstone-card card">
      <div class="padding-around-card-content">
      <h2 class="pt-3">Capstone Presentation</h2>
      <h4>March 29, 2019</h4>
      <div class=" card-img"><img alt="Capstone presentation" class="card-img-top rounded img-fluid" src="img/capstone-pres-pic.PNG" style="border: solid 3px #01426a;"></div>
      <div class="card-body">
        <p class="card-text">I did my capstone presentation on the assignment / task planner software that I developed in a group for my Internet Computing class. I worked more on the project after the class was over and was able to implement a JavaScript library for time successfully within an hour that my group was struggling with for two weeks. I was thus able to give a capstone presentation where the timeline lines, no matter whether it was a short or long term event worked correctly for each event. There had been bugs when initially presented at the end of the semester in Internet Computing.</p>

      </div>
    </div>
    </div>
  </div>

  <div class="quote">
    <div class=" container">
      <div class="bottom-capstone-card card">
        <h3 class="pt-3 pb-3">Capstone Presentation Video (2 Parts)</h3>
        <div class="container">
          <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
              <div class="embed-responsive embed-responsive-16by9">
                <iframe src="https://www.youtube.com/embed/videoseries?list=PLDamcZx0Y6HLmosxcQxZiTA22VQX-zMLJ"></iframe>
              </div>
            </div>
          </div>
        </div>
        <div class="card-body"></div>
      </div>
    </div>
</div>
<?php include 'footer.php';?>
</body>
</html>
