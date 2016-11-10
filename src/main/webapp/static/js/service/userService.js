'use strict';

App.factory('userService', ['$http', '$q', function($http, $q){

	return {
		
		
		    addUser: function(user){
		    		console.log("add user"+user.login);
					return $http.post('/jebouquine/rest/addUser/', user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while adding User');
										return $q.reject(errResponse);
									}
							);
		    	},login: function(user){
					return $http.post('/jebouquine/login', user)
					.then(
							function(response){
								console.log("login service authentication succeeded");
							}, 
							function(errResponse){
								console.error('Error while login');
								return $q.reject(errResponse);
							}
					);
    	},getLoggedUser: function(){
			return $http.post('/jebouquine/rest/getLoggedUser')
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while fetching logged user');
						return $q.reject(errResponse);
					}
			);
}
			}
}]);
