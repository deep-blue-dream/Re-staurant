import axios from 'axios';

// 테스트용 주석
export const instance = axios.create({
 // baseURL: 'http://localhost:8080',
 baseURL: 'http://43.200.202.164:8080',
});

instance.interceptors.response.use(
  (res) => {
    return res;
  },
  async (error) => {
    try {
      const errResponseStatus = error.response.status;
      const prevRequest = error.config;
      if (errResponseStatus === 401) {
        const refreshedToken = error.response.data.message;
        prevRequest.headers.Authorization = refreshedToken;
        localStorage.setItem('accessToken', refreshedToken);
        return await axios(prevRequest);
      }
    } catch (e) {
      return Promise.reject(e);
    }
  }
);
