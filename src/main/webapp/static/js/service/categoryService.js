'use strict';

App.factory('categoryService', ['$http', '$q', function($http, $q){

	return {
		
		fetchAllCategories: function() {
					return $http.get('/jebouquine/rest/category/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.log("error in service");
										console.error('Error while fetching category');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createCategory: function(category){
					return $http.post('/jebouquine/rest/category/', category)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating category');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateCategory: function(category, id){
					return $http.put('/jebouquine/rest/category/'+id, category)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating Category');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteCategory: function(id){
					return $http.delete('/jebouquine/rest/category/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting Category');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
