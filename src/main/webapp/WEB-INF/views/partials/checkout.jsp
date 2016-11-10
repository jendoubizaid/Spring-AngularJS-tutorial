
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="row">
	<div class="col-sm-12" ng-if="mainCtrl.cartBooks.length>0">
		<div id="checkout_box" class="container">
			<div class="table-responsive">
				<table class="table table-stripped">
					<thead>
						<tr style="">
							<th></th>
							<th>produit</th>
							<th>quantité</th>
							<th>prix</th>
							<th>total</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="book in mainCtrl.cartBooks track by $index">

							<td><img
								ng-src="<c:url value='/admin/bookPhoto/{{book.isbn}}'/>"
								width="80px" height="80px"></td>
							<td><span ng-bind="book.name"></span></td>
							<td><input value=1 type="number" size="25" min="0"
								ng-model="mainCtrl.commandedBooks.orderRawList[$index].qte"
								ng-init="mainCtrl.commandedBooks.orderRawList[$index].qte=1" /></td>
							<td><span ng-bind="book.price">DT</span></td>
							<span ng-init="mainCtrl.total=mainCtrl.total + book.price"></span>
							<td ng-init"tot=0">{{tot=mainCtrl.commandedBooks.orderRawList[$index].qte
								* book.price}}DT</td>
							<td><a class="glyphicon glyphicon-remove"
								ng-click="mainCtrl.remove(book.isbn,$index)"></a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<h3>Total :</h3>
			<h2 id="total_sum">{{mainCtrl.getTotal()}}</h2>
			<a class="btn btn-primary" ng-click="mainCtrl.order()"> checkout
				<span class="glyphicon glyphicon-shopping-cart"></span>
			</a> <a class="btn btn-primary" ng-click="mainCtrl.clearCoockies()">
				vider le panier <span class="glyphicon  glyphicon-remove-sign"></span>
			</a>


		</div>
	</div>
	<section ng-if="mainCtrl.cartBooks.length==0">
		<div class="row">
			<div class="col-sm-12">
				<h3>YOUR SHOPPING CART IS EMPTY</h3>

			</div>

		</div>
		<div class="row">
			<div class="col-sm-12">
				<img src="<c:url value='/static/img/shopping-cart-empty-icon.png' />">
			</div>

		</div>
	</section>
</div>