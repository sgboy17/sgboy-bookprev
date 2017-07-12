
var app = angular.module ('bookprev', []);

app.controller("bookprevCtrl", function ($scope, $http) {

    $scope.refreshCart = function (sessionId){
        $http.get('/rest/cart/' + $scope.sessionId).success(function (data) {
            $scope.cart = data;
        })
    };

    $scope.clearCart = function (){
        $http.delete('/rest/cart/' + $scope.sessionId).success(
            $scope.refreshCart($scope.sessionId)
        )
    };

    $scope.initCartId = function (sessionId) {
        $scope.sessionId = sessionId;
        $scope.refreshCart(sessionId);
    };

    $scope.addToCart = function (productId) {
        $http.put('/rest/cart/add/' + productId).success( function (data) {
           $scope.refreshCart($http.get('/rest/cart/cartId'));
           alert("Product successfully added to the cart!");
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put('/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/rest/cart/cartId'));
        });
    };
})