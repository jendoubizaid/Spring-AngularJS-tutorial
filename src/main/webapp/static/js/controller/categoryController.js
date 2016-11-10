'use strict';

App.controller('categoryController', ['$scope', 'categoryService', function($scope, categoryService) {
          var self = this;
          self.category={name:''};
          self.categories=[];
              
          self.fetchAllCategories = function(){
              categoryService.fetchAllCategories()
                  .then(
      					       function(d) {
      						        self.categories = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
           
          self.createCategory = function(category){
              categoryService.createCategory(category)
		              .then(
                      self.fetchAllCategories, 
				              function(errResponse){
					               console.error('Error while creating Category.');
				              }	
                  );
          };

			         self.updateCategory = function(category, name){
              categoryService.updateCategory(category, name)
		              .then(
				              self.fetchAllCategories, 
				              function(errResponse){
					               console.error('Error while updating Category.');
				              }	
                  );
          };

         self.deleteCategory = function(name){
              categoryService.deleteCategory(name)
		              .then(
				              self.fetchAllCategories, 
				              function(errResponse){
					               console.error('Error while deleting Category.');
				              }	
                  );
          };

          self.fetchAllCategories();

          self.submit = function() {
//              if(self.category.name==null){
                  console.log('Saving New Category', self.category);    
                  self.createCategory(self.category);
//              }else{
//                  self.updateBook(self.category, self.category.name);
//                  console.log('User updated with id ', self.category.name);
//              }
              self.reset();
          };
              
          self.edit = function(name){
              console.log('id to be edited', name);
              for(var i = 0; i < self.categories.length; i++){
                  if(self.categories[i].name == name) {
                     self.category = angular.copy(self.categories[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(name){
              console.log('id to be deleted', name);
              if(self.category.name === name) {//clean form if the category to be deleted is shown there.
                 self.reset();
              }
              self.deleteCategory(name);
          };

          
          self.reset = function(){
              self.category={name:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);