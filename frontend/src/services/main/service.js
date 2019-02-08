import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios";
import qs from "qs";

Vue.use(VueAxios, axios);
Vue.axios.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
Vue.axios.defaults.baseURL = "http://localhost:8081";

const MainService = {

  async query(resource, params) {
    try {
      return await Vue.axios.get(
        resource,

        {
          params,
          paramsSerializer: ({ params }) =>
            qs.stringify(params, {
              skipNulls: true,
              format: "RFC1738",
              indices: false
            })
        }
      );
    } catch (error) {
      return Promise.reject(new HttpException(error));
    }
  },

  async get(resource, slug = "") {
    try {
      return await Vue.axios.get(`${resource}/${slug}`);
    } catch (error) {
      return Promise.reject(new HttpException(error));
    }
  },

  async post(resource, params) {
    try {
      return await Vue.axios.post(`${resource}`, params);
    } catch (error) {
      return Promise.reject(new HttpException(error));
    }
  },

  async update(resource, slug, params) {
    try {
      return await Vue.axios.put(`${resource}/${slug}`, params);
    } catch (error) {
      return Promise.reject(new HttpException(error));
    }
  },

  async put(resource, params) {
    try {
      return await Vue.axios.put(`${resource}`, params);
    } catch (error) {
      return Promise.reject(new HttpException(error));
    }
  },

  async delete(resource) {
    try {
      return await Vue.axios.delete(resource);
    } catch (error) {
      return Promise.reject(new HttpException(error));
    }
  }
};

export default MainService;
