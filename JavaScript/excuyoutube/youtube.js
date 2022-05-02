// document.cookie = 'visited=true; Max-Age=2600000; Secure';
// const apiKey = '키 값';
// const c1 = 'UCfqVrM2cvwxG3-EvxbsN0KQ';
// const c2 = "UCoe-0EVDJnjlSoPK8ygcGwQ";
// const c3 = "UCxHcczukcG21up2MBe8yP_Q";
// const videoChannel = document.querySelector("#video_channel")
// const videoChannel1 = document.querySelector("#video_channel1")
// const videoChannel2 = document.querySelector("#video_channel2")


// const channelEndPoint = `https://www.googleapis.com/youtube/v3/channels?key=${apiKey}&id=${c1},${c2},${c3}&part=snippet,contentDetails,statistics`;

//     const ytPromise = fetch(channelEndPoint)
//     .then((res)=> res.json())
//     .then((data)=> {
//         console.log(data);
//         showChannel(data);
//     });
//     function showChannel(data){
//         for(let i = 0; i<data.items.length; i++){
//             let items = data.items[i];
//             let output = `<div>
//                 <img class="img-flude" src="${items.snippet.thumbnails.default.url}">
//                 <h1>${items.snippet.title}</h1>
//                 <p>${Number(items.statistics.subscriberCount).toLocaleString('en')} 명</p>
//             </div>`;
//             if( i === 0 )
//             videoChannel.innerHTML= output; 
//             else if( i === 1)
//             videoChannel1.innerHTML= output; 
//             else if( i === 2)
//             videoChannel2.innerHTML= output; 
//         }
//     }
    // function order(data){
    //     for(let i = 0; i<data.length; i++){
    //         let temp =0;
    //         for(let j = i+1; j<data.length;j++){
    //             if(data[i].statistics.subscriberCount < data[j].statistics.subscriberCount){
    //                 temp = data[i];
    //                 data[i] = data[j];
    //                 data[j] = temp;
    //             }
    //         }
    //     }
    // }
            /* const imgLink = data.items[i].snippet.thumbnails.medium.url;
            const h1 = data.items[i].snippet.title;
            const 구독자 = data.items[i].statistics.subscriberCount;
            ;
            let output = `<div>
                <img class="img-flude" src="${imgLink}">
                <h1>${h1}</h1>
                <p>${구독자} 명</p>
            </div>`;
            if(i===0)
            videoChannel.innerHTML= output; 
            else(i===1)
            videoChannel1.innerHTML = output;
        } */
   // }

    // function showChannel(data){
    //     const imgLink = data.items[0].snippet.thumbnails.medium.url;
    //     const h1 = data.items[0].snippet.title;
    //     const 구독자 = data.items[0].statistics.subscriberCount;
    
        //     let output = 
        //     `
        //     <div>
        //         <img class="img-flude" src="${imgLink}">
        //         <h1>${h1}</h1>
        //         <p>${구독자} 명</p>
        //     </div>
        //     `;
        // videoChannel.innerHTML= output; 
    // }
    // function showChannel1(data){
    //     const imgLink1 = data.items[0].snippet.thumbnails.medium.url;
    //     const h11 = data.items[0].snippet.title;
    //     const 구독자1 = data.items[0].statistics.subscriberCount;

    //         let output1 = 
    //         `
    //         <div>
    //             <img class="img-flude" src="${imgLink1}">
    //             <h1>${h11}</h1>
    //             <p>${구독자1} 명</p>
    //         </div>
    //         `;
         
    //     videoChannel1.innerHTML= output1;  
    // }
       
    const apiKey = '키값';
    const 강민경 = 'UCfqVrM2cvwxG3-EvxbsN0KQ';
    const 김종국 = "UCoe-0EVDJnjlSoPK8ygcGwQ";
    const 감스트 = "UCbFzvzDu17eDZ3RIeaLRswQ";
    const 안지영 = "UCg-4w6P9kE3QNP13LwtwUKw";
    const 노마드코더 = "UCUpJs89fSBXNolQGOYKn0YQ";
    const 정찬성 = "UCc7o0OkR2BDFN4TCgPChjEw";
    const 딩고 = "UCtCiO5t2voB14CmZKTkIzPQ";
    
    const dataItem = [
        김종국,
        감스트,
        강민경,
        안지영,
        노마드코더,
        정찬성,
        딩고,
    ]
    
    
    const channelEndPoint = `https://www.googleapis.com/youtube/v3/channels?key=${apiKey}&id=${[...dataItem]}&part=snippet,contentDetails,statistics`;
    
    const ytPromise = fetch(channelEndPoint)
        .then((res)=> res.json())
        .then((data)=> {
            showChannel(data);
        }).catch((err)=>{console.log(err+"에러입니다")}); 
    
    function showChannel(data){
    
        console.log(data);
    
        for(let i = 0; i<dataItem.length; i++){
            const imgLink = data.items[i].snippet.thumbnails.medium.url;
            const 국적 = data.items[i].snippet.country;
            const h1 = data.items[i].snippet.title;
            const 구독자 = data.items[i].statistics.subscriberCount;
            const 조회수 = data.items[i].statistics.viewCount;
            const 소개 = data.items[i].snippet.description;
            let output = `<div id="item">
                <img id="img-flude" src="${imgLink}">
                <h1>${h1}</h1>
                <h5>${국적}</h5>
                <p>${구독자} 명</p>
                <p>${조회수}</p>
                <h3>${소개}</h3>
                </div>`;
    
            switch(i) {
                case i : document.getElementById(`item${i}`).innerHTML = output;
            }
        }
    
        // let output = `
        // <div>
        // <img src="${imgLink}"/>
        // <h3>${h1}</h3>
        // <p>${구독자} 명</p>
        // </div>
        // `;
        // videoChannel.innerHTML= output;
    }
    // option = API KEY, 내 채널 ID, 내 채널 파라미터