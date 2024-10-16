import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import {
  BASE_URL,
  FUMETTI_BY_GENERE_TIPO,
  FUMETTI_BY_CASA_EDITRICE_TIPO,
  FUMETTI_BY_TIPO,
  FUMETTI_BY_AUTORE_TIPO,
  FUMETTI_BY_RACCOMANDATO_TIPO,
  FUMETTI_BY_FRANCHISE_TIPO,
  FUMETTI_RECOMMENDED,
  FUMETTI_BY_TITOLO
} from "../utility/apiConstants";

export const FumettoApi = createApi({
  reducerPath: "fumettoApi",
  baseQuery: fetchBaseQuery({
    baseUrl: BASE_URL,
    prepareHeaders: (headers) => {
      headers.set("Access-Control-Allow-Origin", "*");
      return headers;
    },
  }),
  tagTypes: [],
  endpoints: (builder) => ({
    getFumettiByGenereAndTipo: builder.query({
      query: ({ genere, tipo }) => ({
        url: `${FUMETTI_BY_GENERE_TIPO}?genere=${genere}&tipo=${tipo}`,
      }),
    }),
    getFumettiByCasaEditriceAndTipo: builder.query({
      query: ({ casaEditrice, tipo }) => ({
        url: `${FUMETTI_BY_CASA_EDITRICE_TIPO}?casaEditrice=${casaEditrice}&tipo=${tipo}`,
      }),
    }),
    getFumettiByTipo: builder.query({
      query: (tipo) => ({
        url: `${FUMETTI_BY_TIPO}?tipo=${tipo}`,
      }),
    }),
    getFumettiByAutoreAndTipo: builder.query({
      query: ({ nome, cognome, tipo }) => ({
        url: `${FUMETTI_BY_AUTORE_TIPO}?nome=${nome}&cognome=${cognome}&tipo=${tipo}`,
      }),
    }),
    getFumettiByRaccomandatoAndTipo: builder.query({
      query: ({ tipo }) => ({
        url: `${FUMETTI_BY_RACCOMANDATO_TIPO}/tipo/${tipo}`,
      }),
    }),
    getFumettiByFranchiseAndTipo: builder.query({
      query: ({ franchise, tipo }) => ({
        url: `${FUMETTI_BY_FRANCHISE_TIPO}?franchise=${franchise}&tipo=${tipo}`,
      }),
    }),
    getRecommendedFumetti: builder.query({
      query: ({ tipo, utenteId }) => ({
        url: `${FUMETTI_RECOMMENDED}/${tipo}/utente/${utenteId}`,
      }),
    }),
    getFumettoByTitolo: builder.query({
      query: (titolo) => ({
        url: `${FUMETTI_BY_TITOLO}?titolo=${titolo}`,
      }),
    }),
  }),
});

export const {
  useGetFumettiByGenereAndTipoQuery,
  useGetFumettiByCasaEditriceAndTipoQuery,
  useGetFumettiByTipoQuery,
  useGetFumettiByAutoreAndTipoQuery,
  useGetFumettiByRaccomandatoAndTipoQuery,
  useGetFumettiByFranchiseAndTipoQuery,
  useGetRecommendedFumettiQuery,
  useGetFumettoByTitoloQuery,
} = FumettoApi;
