
const url = "http://localhost:8080/WEB-INF/api/v1/";

const createRequest = (method,data) => {
    return {
        method: method,
        mode: 'cors',
        cache: 'default',
        body: JSON.stringify(data)
    };
};

const req = (path, config) => {return fetch(url + path, config)};

