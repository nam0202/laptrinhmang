'use strict';


var stompClient = null;

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, onConnected, onError);
}

// Connect to WebSocket Server.
connect();
onConnected();
function onConnected() {
    stompClient.subscribe('/topic/listener', onMessageReceived);

}

function onError(error) {
    console.log('Could not connect to WebSocket server. Please refresh this page to try again!');
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    if(message.content === 'Mua Hang'){
        var result = confirm('Có người mới đặt hàng, Vào xem danh sách hóa đơn?');
        console.log(result);
        if(result){
            location.replace(window.location.origin+'/admin/hoadon');
        }
    }
}
