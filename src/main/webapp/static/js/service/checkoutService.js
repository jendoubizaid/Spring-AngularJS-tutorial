'use strict';

App.factory('checkoutService', ['$http', '$q', function($http, $q){

	return {
		
			checkout:function(commandedBooks){
	    	return $http.post('/jebouquine/rest/checkout/',commandedBooks)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while passing command');
						return $q.reject(errResponse);
					}
			);
	    }
	};
	    }]);
