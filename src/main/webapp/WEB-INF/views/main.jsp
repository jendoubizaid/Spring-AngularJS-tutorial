<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bookstore</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value='/static/css/bootstrap.min.css' />">
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/main.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/font-awesome-4.6.3/css/font-awesome.min.css' />">
</head>
<body style="background-color: #FAF0E6" ng-app="myApp"
	ng-controller="checkoutController as mainCtrl">
	<!--===========================================Header==================================================== -->

	<div class="row" style="background-color: #4DB6AC">
		<div class="col-sm-2" align=center>
			<div ng-if="!mainCtrl.authenticated">
				<a href="#/login"> <span class="glyphicon glyphicon-log-in"></span>
				</a> <br>
				<h6 id="client_name"><a href="#/login" class="white_text">login</a>|<a href="#/signup" class="white_text">sign up</a> </h6>
			</div>
			<div ng-if="mainCtrl.authenticated">
				<a href="connexion_client.html"> <img class="header_pic"
					src="<c:url value='/static/img/profile.png' />" />
				</a> <br>
				<h6 id="client_name">{{loggedUserName}}</h6>
				<a id="logout_btn" href="<c:url value='/logout' />"
					ng-click="mainCtrl.clearCoockies()"> <span
					class="glyphicon glyphicon-log-out"></span>
				</a> <br>
			</div>
		</div>

		<div class="col-sm-8" align=center>
			<div class="collapse navbar-collapse" id="search">
				<form class="navbar-form " role="search"
					ng-submit="redirect(keyword)">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="trouvez un livre,un auteur..." ng-model="keyword" />
						<span class="input-group-btn"> <a
							href="#/booksearch/{{keyword}}" class="btn btn-default"> <span
								class="glyphicon glyphicon-search"></span>
						</a>
						</span>
					</div>
				</form>
			</div>
		</div>

		<div class="col-sm-2" align=center>
			<div id="cart">
				<a href="#/checkout" ng-click="mainCtrl.findBooksByIsbn()"><img
					class="header_pic" src="<c:url value='/static/img/cart2.png' />" />
				</a><br>
				<h6 id="total_items">
					{{mainCtrl.cart.length}} items
					<h6 />
			</div>
		</div>
	</div>
	<div id="header_nav" class="row" align=center>
		<nav class="navbar navbar-custom" role="navigation">


			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<div class="row">
					<div class="col-sm-2">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#search">
							<span class="sr-only">Toggle search</span> <span
								class="glyphicon glyphicon-search"></span>
						</button>
					</div>
					<div class="col-sm-8"></div>
					<div class="col-sm-2">

						<span class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-navbar-collapse-1"> <span class="sr-only">Toggle
								navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</span>
					</div>

				</div>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-navbar-collapse-1">
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-sm-10">
						<ul class="nav navbar-nav"
							ng-controller="categoryController as ctrl">
							<li class="external"><a href="#/"><span
									class="glyphicon glyphicon-home"> </span> </a></li>
							<li class="external" ng-repeat="cat in ctrl.categories"><a
								href="#/theme/{{cat.name}}">{{cat.name}}</a></li>
						</ul>

					</div>
					<div class="col-sm-1"></div>
				</div>

			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</div>
	<!-- core content -->
	<div id="main_container">
		<div ng-view></div>
		</div>
	<!--footer -->
	<footer class="container-fluid bg-footer " align=center>
		<a class="btn btn-social-icon btn-twitter"> <span
			class="fa fa-twitter"></span>
		</a> <a class="btn btn-social-icon btn-linkedin"> <span
			class="fa fa-linkedin"></span>
		</a> <a class="btn btn-social-icon btn-facebook"> <span
			class="fa fa-facebook"></span>
		</a> <a class="btn btn-social-icon btn-vimeo"> <span
			class="fa fa-vimeo"></span>
		</a>

	</footer>
	
	<script src="<c:url value='/static/js/jquery-1.12.3.js' />"></script>
	<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/static/angular/angular.min.js' />"></script>
	<script src="<c:url value='/static/angular/angular-route.min.js' />"></script>
	<script src="<c:url value='/static/angular/angular-cookies.min.js' />"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/bookService.js' />"></script>
	<script src="<c:url value='/static/js/service/categoryService.js' />"></script>
	<script src="<c:url value='/static/js/service/userService.js' />"></script>
	<script src="<c:url value='/static/js/service/checkoutService.js' />"></script>
	<script src="<c:url value='/static/js/controller/bookController.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/bookDetailsController.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/checkoutController.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/searchBookController.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/categoryController.js' />"></script>
	<script src="<c:url value='/static/js/controller/UserController.js' />"></script>
</body>
</html>
