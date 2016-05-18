/**
 * Created by mijo on 2015-07-15.
 */
app.controller('WebSocketController', ['$scope', '$websocket', 'ConnectionFactory', function ($scope, $websocket, ConnectionFactory) {

    $scope.ConnectionFactory = ConnectionFactory;

    var clientData = {
        oid: "default",
        id: $scope.messageid,
        action: "acknowledge"
    };


    $scope.submit = function () {
        //clientData = $scope.
        console.log('message id from textbox ' + $scope.messageid);
        ConnectionFactory.send({
            id: $scope.messageid
            // Look at : http://stackoverflow.com/questions/19985344/angularjs-simple-form-submit
        });
    }

    //$scope.username = 'anonymous';
    //$scope.ConnectionFactory = ConnectionFactory;
    //$scope.submit = function(new_message) {
    //    if (!new_message) { return; }
    //    ConnectionFactory.send({
    //        username: $scope.username,
    //        message: new_message
    //    });
    //    $scope.new_message = '';
    //};

}]);