'use strict';

App.controller('bookDetailsController', ['$scope','$routeParams', 'bookService', function($scope,$routeParams, bookService) {
          
		  $scope.oneBook=bookService.fetchBookByISBN($routeParams.isbn)
                  .then(
      					       function(d) {
      					    	   console.log("book found"+d);
      					    	 $scope.oneBook = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
}]);