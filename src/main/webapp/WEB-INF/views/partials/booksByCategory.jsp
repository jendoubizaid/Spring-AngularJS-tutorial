<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<h2>{{cat}}:</h2>
	</div>
</div>
<div class="row">
	<hr size=4 width=100% align=center>
</div>
<div class="row">
	<div class="col-sm-4 book-alignment" align=center
		ng-repeat="book in catBooks">
		<a href="#/bookDetails/{{book.isbn}}">
			<div class="circle_grey">
				<img class="book"
					ng-src="<c:url value='/admin/bookPhoto/{{book.isbn}}'/>" /> <br>
			</div>
		</a> <a class="btn btn-primary btn-margin"
			ng-click="mainCtrl.addToCart(book.isbn,book.price)"> <span
			class="glyphicon glyphicon-shopping-cart"></span> add to Cart
		</a>
	</div>
</div>

<div id="container">
	<br> <img id="img-center"
		src="<c:url value='/static/img/HappyReading.png'/>"
		class="img-responsive" width="125" height="125" />
</div>
