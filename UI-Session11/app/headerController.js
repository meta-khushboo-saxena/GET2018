angular.module('shoppingApp').controller('headerController', function($scope, $http) {
	$http.get('http://localhost:3000/cart').then(function(response){
      $scope.cartList = response.data;
      console.log(cartList.length)
    });



});