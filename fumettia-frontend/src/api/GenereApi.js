import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import {
  BASE_URL,
  GENERI
} from "../utility/apiConstants";

export const GenereApi = createApi({
  reducerPath: "genereApi",
  baseQuery: fetchBaseQuery({
    baseUrl: BASE_URL,
    prepareHeaders: (headers) => {
      headers.set("Access-Control-Allow-Origin", "*");
      return headers;
    },
  }),
  tagTypes: [],
  endpoints: (builder) => ({
    getGeneri: builder.query({
      query: () => ({
        url: `${GENERI}`,
      }),
    }),
  }),
});

export const {
  useGetGeneriQuery
} = GenereApi;
