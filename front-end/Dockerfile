FROM node:10-alpine

RUN npm install express path

RUN mkdir /build
COPY build /build/
COPY serve.js /serve.js


CMD ["node", "/serve.js"]