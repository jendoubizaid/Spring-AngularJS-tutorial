<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body style="background-color: #FAF0E6">
	<!--======================================= Header ===========================================-->

	<div class="row" style="background-color: #4DB6AC">
		<div class="col-sm-2" align=center>
			<a href="#"> <img class="header_pic"
				src="<c:url value='/static/img/profile.png' />" />
			</a> <br>
			<h6 id="client_name">
				hello admin
				<h6 />
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
		<div class="row">
			<div class="col-sm-12">
				<div class="container">
					
						<table class="table table-hover">
							<thead>
								<tr>
									<th>ISBN</th>
									<th>Title</th>
									<th>price</th>
									<th>description</th>
									<th>author</th>
									<th>image</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${books}" var="book">
								<tr>
									<td>${book.isbn}</td>
									<td>${book.name}</td>
									<td>${book.price}</td>
									<td>${book.description}</td>
									<td>${book.author}</td>
									<td><img
										src="${contextPath}/jebouquine/admin/bookPhoto/${book.isbn}"
										height="100" width="70"></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					
				</div>
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

</body>
<script src="<c:url value='/static/js/jquery-1.12.3.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
</html>