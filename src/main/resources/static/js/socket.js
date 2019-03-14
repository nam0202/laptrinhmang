'use strict';


var stompClient = null;

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, onConnected, onError);
}

// Connect to WebSocket Server.
connect();
function muahang(e) {
    var numbers = document.getElementById("numbers-submit");
    var index = document.getElementById("index");
    var chatMessage = {
        sender: numbers.value,
        content: 'Mua Hang',
        index: index.innerText
    };
    stompClient.send("/app/chat.status", {}, JSON.stringify(chatMessage));
    // alert("Mua hàng thành công. Chúng tôi sẽ liên hệ sớm với bạn")
}


function onError(error) {
    console.log('Could not connect to WebSocket server. Please refresh this page to try again!');
}

onConnected();
function onConnected() {
    stompClient.subscribe('/topic/change', onMessageReceived);

}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    if(message.content === 'CHANGE'){
        var result = window.alert('Có sự thay đổi về mặt hàng');
        location.reload(true);
    }

}
