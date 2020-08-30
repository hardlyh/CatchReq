$(function () {

    var app2 = new Vue({
        el: '#app',
        data: {
            reqList: [

            ],
            baseUrl: 'http://localhost:8080/',
            selectReq: {
              
            },
            responseT: '',
        },
        methods: {
            snedGet: function (url, param = {}, headers = {}) {
                var vm = this;
                axios({
                    method: "GET",
                    url: vm.baseUrl + url,
                    params: param,
                    headers: headers
                }).then(function (res) {
                    console.log(res);
                    vm.reqList = res.data;
                }).catch(function (error) {
                    
                });
            },
            snedGet2: function (url, param = {}, headers = {}) {
                var vm = this;
                axios({
                    method: "GET",
                    url: url,
                    params: param,
                    headers: headers
                }).then(res=>{
                    vm.responseT = res.data;
                }).catch(function (error) {
                    vm.responseT = error.data;
                });
            },
            sendPost: function (url, param = {}, headers = {}) {
                var vm = this;
                axios({
                    method: "POST",
                    url: url,
                    data: param,
                    headers: headers
                }).then(res=>{
                    vm.responseT = res.data;
                }).catch(function (error) {
                    vm.responseT = error.data;
                });
            },
            getAll: function () {
                this.snedGet('/reqCatchGetAll')
            },
            clickReq: function (req) {
                this.selectReq = req;
                console.log(this.selectReq.headersMap[1]);
            },
            submitUrl: function () {
                if (this.selectReq.mehtod == 'GET') {
                    this.snedGet2(this.baseUrl+this.selectReq.targetMethod, this.selectReq.paramMap, this.selectReq.headersMap);
                } else {
                    var params = new URLSearchParams();
                    for (order in this.selectReq.paramMap) {
                        params.append(order, this.selectReq.paramMap[order])
                    }
                    this.sendPost(this.baseUrl+this.selectReq.targetMethod, params, this.selectReq.headersMap);
                }
            },
            getBaseUrl:function(){
                var urlMatches = /(.*)\/reqCatch.html.*/.exec(window.location.href);
                this.baseUrl = urlMatches[1];
            },
            removeHeader:function(key){
                alert("remove");
                alert(key);
            }
        },
        mounted: function () {
            this.getBaseUrl();
            this.getAll();
        }
    })

})