'use strict';

App.controller('searchBookController', ['$scope','$routeParams', 'bookService', function($scope,$routeParams, bookService) {
	      
		  $scope.keyword=$routeParams.key;
		  $scope.searchedBooks=bookService.fetchBooksByKeyWord($routeParams.key)
                  .then(
      					       function(d) {
      					    	   console.log("book found"+d);
      					    	 $scope.searchedBooks = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
		  
		  self.fetchBooksByKeyWord = function () {
              bookService
                  .fetchBooksByKeyWord(self.keyword)
                  .then(
                      function (d) {
                          self.searchedBooks = d;
                      },
                      function (errResponse) {
                          console
                              .error('Error while fetching books by key word');
                      });
          };
		  $scope.catBooks=bookService.fetchBooksByCat($routeParams.cat)
          .then(
				       function(d) {
				    	   console.log("book by cat found"+d);
				    	 $scope.catBooks = d;
				       },
					function(errResponse){
						console.error('Error while fetching Currencies');
					}
		       );
		  $scope.cat=$routeParams.cat;	

}]);