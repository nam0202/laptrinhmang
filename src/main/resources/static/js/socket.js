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
    console.log(index.text);
    var chatMessage = {
        number: numbers.value,
        content: 'Mua Hang',
        index: 1
    };
    stompClient.send("/app/chat.status", {}, JSON.stringify(chatMessage));
    // alert("Mua hàng thành công. Chúng tôi sẽ liên hệ sớm với bạn")
}


function onError(error) {
    console.log('Could not connect to WebSocket server. Please refresh this page to try again!');
}


