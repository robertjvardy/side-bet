import axios from "axios";

export const http = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL,
});

// TODO once BE is set up to pass JWT set this here
http.defaults.headers.common["Authorization"] = "AUTH_TOKEN";
