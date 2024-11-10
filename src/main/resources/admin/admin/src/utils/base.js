const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot49c2c/",
            name: "springboot49c2c",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot49c2c/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "游戏分享网站"
        } 
    }
}
export default base
