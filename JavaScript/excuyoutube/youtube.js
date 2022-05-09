// 순서 3)
// => API 호출 구문
// => 수정 할 내용
// => div를 반복문에 추가해서 html 코드 최소화

import {dataItem} from './data.js';

// my api key
const apiKey = 'MyAPi Key';

const channelEndPoint = `https://www.googleapis.com/youtube/v3/channels?key=${apiKey}&id=${[...dataItem]}&part=snippet,contentDetails,statistics`;

// 비동기처리
const youtubeAPI = fetch(channelEndPoint)
.then((res)=> res.json(youtubeAPI))
 // json에 youtubeAPI을 파라미터로 넣어주니 해결 됨
.then((data)=> {
    console.log(data);
    showChannel(data);
}).catch((err)=>{console.log(err+"에러입니다")});

function showChannel(data){

    for(let i = 0; i<dataItem.length; i++){
        const imgLink = data.items[i].snippet.thumbnails.medium.url;
        const 국적 = data.items[i].snippet.country;
        const 채널명 = data.items[i].snippet.title;
        const 구독자 = data.items[i].statistics.subscriberCount;
        const 조회수 = data.items[i].statistics.viewCount;
        const 소개 = data.items[i].snippet.description;

        if(구독자 === ""){
            구독자 = "비공개"
        }
        // 구독자가 비공개면 null 이 아니라 비공개를 띄움

        let output = `
            <div class="item">
            <span>${i + 1}</span>
            <img class="img-flude" src="${imgLink}">
                <div class="item_box">
                    <h1>${채널명}</h1>
                    <p>${구독자} 명</p>
                    <h3>${소개}</h3>
                </div>
            </div>`;

        switch(i) {
            case i : document.getElementById(`item${i}`).innerHTML = output;
        }
    }
}
// option = API KEY, 내 채널 ID, 내 채널 파라미터
