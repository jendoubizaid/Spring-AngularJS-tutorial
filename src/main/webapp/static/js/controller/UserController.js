'use strict';

App.controller('UserController', ['$scope','$location', 'userService', function($scope,$location, userService) {
          
			$scope.user={};
		  $scope.addUser=function(){
			  userService.addUser($scope.user)
                  .then(function(d) {
      					   console.log("user added successfully"+d);
      					    $location.path("/login")
      					    },
            			function(errResponse){
            				console.error('Error while fetching Currencies');
            			}
      			       );
		  }
}]);