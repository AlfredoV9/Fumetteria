import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import {
  BASE_URL,
  VOLUMI_PER_FUMETTO,
  ULTIMI_VOLUMI_USCITI
} from "../utility/apiConstants";

export const VolumeApi = createApi({
  reducerPath: "volumeApi",
  baseQuery: fetchBaseQuery({
    baseUrl: BASE_URL,
    prepareHeaders: (headers) => {
      headers.set("Access-Control-Allow-Origin", "*");
      return headers;
    },
  }),
  tagTypes: [],
  endpoints: (builder) => ({
    getVolumiPerFumetto: builder.query({
      query: ({titolo}) => ({
        url: `${VOLUMI_PER_FUMETTO}?titoloFumetto=${titolo}`,
      }),
    }),
    getUltimiVolumiPerTipo: builder.query({
      query: (tipo) => ({
        url: `${ULTIMI_VOLUMI_USCITI}/${String(tipo)}`,
      }),
    }),
  }),
});

export const { 
    useGetUltimiVolumiPerTipoQuery,
    useGetVolumiPerFumettoQuery,
} = VolumeApi;
