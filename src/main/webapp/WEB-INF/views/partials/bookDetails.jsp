<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="desc_book">
	<h1 id="titre_livre">{{oneBook.name}}</h1>
	<hr>
	<div class="row">
		<div class="col-sm-4">
			<img ng-src="<c:url value='/admin/bookPhoto/{{oneBook.isbn}}'/>"
				id="book_cover" height="200px" width="150px">
		</div>
		<div class="col-sm-4">
			<h4 id="nom_auteur"><b>AUTEUR:</b>{{oneBook.author}}</h4>
			<br>
			<h4 id="editeur"><b>EDITEUR:</b>{{oneBook.editor}}</h4>
			<br>
			<h4 id="ISBN"><b>ISBN:</b>{{oneBook.isbn}}</h4>
			<br>
			<h4 id="ISBN"><b>DESCRIPTION:</b></h4>
			<p id="description">{{oneBook.description}}</p>
			<br>
		</div>
		<div class="col-sm-4">
			<div id="prix_livre_box">
				<h2 id="prix">{{oneBook.price}}$</h2>
				<a class="btn btn-primary"
					ng-click="mainCtrl.addToCart(oneBook.isbn,oneBook.price)"> <span
					class="glyphicon glyphicon-shopping-cart"></span> add to Cart
				</a>
			</div>
		</div>
	</div>
</div>