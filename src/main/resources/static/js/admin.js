'use strict';


var stompClient = null;

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, onConnected, onError);
}

// Connect to WebSocket Server.
connect();
function onConnected() {
    stompClient.subscribe('/topic/listener', onMessageReceived);

}
function deleteProduct() {
    var chatMessage = {
        content: 'CHANGE'
    };
    stompClient.send("/app/chat.change", {}, JSON.stringify(chatMessage));
}
function onError(error) {
    console.log('Could not connect to WebSocket server. Please refresh this page to try again!');
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    if(message.content === 'Mua Hang'){
        var result = window.confirm('Có người mới đặt hàng, Vào xem danh sách hóa đơn?');
        console.log(result);
        if(result){
            location.replace(window.location.origin+'/admin/hoadon');
        }else {
            var data = document.getElementById("productID"+message.index);
            console.log(data.innerText, message.sender);
            data.innerText = parseInt(data.innerText) - parseInt(message.sender);
        }
    }
}
