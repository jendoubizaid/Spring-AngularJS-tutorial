<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>add Category</title>
<style>
.category.ng-valid {
	background-color: lightgreen;
}

.category.ng-dirty.ng-invalid-required {
	background-color: red;
}
</style>
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
<body ng-app="myApp" class="ng-cloak">

	<div class="row" style="background-color: #4DB6AC">
		<div class="col-sm-2" align=center>
			<a href="#"> <img class="header_pic"
				src="<c:url value='/static/img/profile.png' />" />
			</a> <br>
			<h6 id="client_name">
				hello admin
				</h6>
		</div>
		<div class="col-sm-8" align=center>
			<div class="collapse navbar-collapse" id="search">
				<form class="navbar-form " role="search">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="trouvez un livre,un auteur..."> <span
							class="input-group-btn">
							<button type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</form>
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
						<ul class="nav navbar-nav">
							<li class="external"><a href="main.html"><span
									class="glyphicon glyphicon-home"> </span> </a></li>
							<li class="external"><a
								href="<c:url value='/admin/books' />">Books</a></li>
							<li class="headerDivider"></li>
							<li class="external"><a href="<c:url value='/admin/add' />">Add
									Book</a></li>
							<li class="external"><a href="<c:url value='/admin/category' />">Categories</a></li>
							<li class="external"><a
								href="<c:url value='/admin/category' />">Add Category</a></li>
						</ul>
					</div>
					<div class="col-sm-1"></div>
				</div>

			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</div>
	<div id="main_container">
	<div class="main_container"
		ng-controller="categoryController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Category Registration Form </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Category
								Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.category.name" name="cname"
									class="username form-control input-sm"
									placeholder="Enter category name" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.cname.$error.required">This is a
										required field</span> <span ng-show="myForm.cname.$error.minlength">Minimum
										length required is 3</span> <span ng-show="myForm.cname.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>




					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Add" class="btn btn-primary btn-sm"
								ng-disabled="myForm.$invalid" style="margin-left: 20px;">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Categories </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="category in ctrl.categories">
							<td><span ng-bind="category.name"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(category.name)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(category.name)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<footer class="container-fluid bg-footer">
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
</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/angular/angular-route.min.js' />"></script>
	<script src="<c:url value='/static/angular/angular-cookies.min.js' />"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/categoryService.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/categoryController.js' />"></script>
</body>
</html>