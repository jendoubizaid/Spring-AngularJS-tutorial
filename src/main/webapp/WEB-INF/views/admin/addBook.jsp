<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value='/static/css/bootstrap.min.css' />">
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/main.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/font-awesome-4.6.3/css/font-awesome.min.css' />">
<title>Book form</title>
</head>
<body>
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
							<li class="external"><a href="#">Categories</a></li>
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
		<h1>add Book</h1>
		
			<f:form method="post" modelAttribute="book"
				enctype="multipart/form-data" class="form-horizontal" role="form">
				<div class="form-group">
					<label class="control-label col-sm-2" for="email">ISBN:</label>
					<div class="col-sm-10">
						<f:input path="isbn" type="text" class="form-control"
							placeholder="Enter ISBN" />
						<f:errors path="isbn"></f:errors>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="title">title:</label>
					<div class="col-sm-10">
						<f:input path="name" type="text" class="form-control"
							placeholder="Enter title" />
						<f:errors path="name"></f:errors>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="title">price:</label>
					<div class="col-sm-10">
						<f:input path="price" type="number" step="0.01" />
						<f:errors path="price"></f:errors>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="description">description:</label>
					<div class="col-sm-10">
						<f:input path="description" type="text" class="form-control"
							placeholder="Enter description" />
						<f:errors path="description"></f:errors>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="title">author:</label>
					<div class="col-sm-10">
						<f:input path="author" type="text" class="form-control"
							placeholder="Enter author name" />
						<f:errors path="author"></f:errors>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="title">editor:</label>
					<div class="col-sm-10">
						<f:input path="editor" type="text" class="form-control"
							placeholder="Enter editor name" />
						<f:errors path="editor"></f:errors>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">category:</label>
					<div class="col-sm-10">
						<f:select path="catName" items="${categoriesName}"
							class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">photo:</label>
					<div class="col-sm-10">
						<input type="file" name="file">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" value="add" class="btn btn-info"
							role="button" />
					</div>
				</div>
			</f:form>
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
	<script src="<c:url value='/static/js/jquery-1.12.3.js' />"></script>
	<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
</body>
</html>