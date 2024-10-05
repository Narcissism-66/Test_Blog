<script setup>
import {onMounted, reactive, ref} from "vue";
import {get} from "@/net/index.js";
import router from "@/router/index.js";
import {useThemeStore} from "@/stores/theme.js";
import AddLinkForm from "@/components/AddLinkForm.vue";
const options=reactive({
  blogs:[]
})
const option_link=reactive({
  links:[]
})
const initDate=()=>{
  get('/api/blog/getIntroduce',{},(message,data)=>{
    options.blogs=data;
  })
}
const initLink=()=>{
  get('/api/link/getAllLinks',{},(message,data)=>{
    option_link.links=data;
  })
}
onMounted(()=>{
  initDate();
  initLink();
})
const showForm = ref(false);

const toggleForm = () => {
  showForm.value = !showForm.value;
};
const themeStore=useThemeStore();
const blogClickHandle=(id)=>{
  router.push("/view/"+id)
}
const siderBar=[{
  title:'精选',
  ico:`<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
  <path stroke-linecap="round" stroke-linejoin="round" d="M9.813 15.904 9 18.75l-.813-2.846a4.5 4.5 0 0 0-3.09-3.09L2.25 12l2.846-.813a4.5 4.5 0 0 0 3.09-3.09L9 5.25l.813 2.846a4.5 4.5 0 0 0 3.09 3.09L15.75 12l-2.846.813a4.5 4.5 0 0 0-3.09 3.09ZM18.259 8.715 18 9.75l-.259-1.035a3.375 3.375 0 0 0-2.455-2.456L14.25 6l1.036-.259a3.375 3.375 0 0 0 2.455-2.456L18 2.25l.259 1.035a3.375 3.375 0 0 0 2.456 2.456L21.75 6l-1.035.259a3.375 3.375 0 0 0-2.456 2.456ZM16.894 20.567 16.5 21.75l-.394-1.183a2.25 2.25 0 0 0-1.423-1.423L13.5 18.75l1.183-.394a2.25 2.25 0 0 0 1.423-1.423l.394-1.183.394 1.183a2.25 2.25 0 0 0 1.423 1.423l1.183.394-1.183.394a2.25 2.25 0 0 0-1.423 1.423Z" />
</svg>
`
},{
  title:'关注',
  ico:`<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
  <path stroke-linecap="round" stroke-linejoin="round" d="M11.48 3.499a.562.562 0 0 1 1.04 0l2.125 5.111a.563.563 0 0 0 .475.345l5.518.442c.499.04.701.663.321.988l-4.204 3.602a.563.563 0 0 0-.182.557l1.285 5.385a.562.562 0 0 1-.84.61l-4.725-2.885a.562.562 0 0 0-.586 0L6.982 20.54a.562.562 0 0 1-.84-.61l1.285-5.386a.562.562 0 0 0-.182-.557l-4.204-3.602a.562.562 0 0 1 .321-.988l5.518-.442a.563.563 0 0 0 .475-.345L11.48 3.5Z" />
</svg>
`
},{
  title:'评论',
  ico:`<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
  <path stroke-linecap="round" stroke-linejoin="round" d="M8.625 9.75a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H8.25m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H12m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0h-.375m-13.5 3.01c0 1.6 1.123 2.994 2.707 3.227 1.087.16 2.185.283 3.293.369V21l4.184-4.183a1.14 1.14 0 0 1 .778-.332 48.294 48.294 0 0 0 5.83-.498c1.585-.233 2.708-1.626 2.708-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0 0 12 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018Z" />
</svg>
`
},{
  title:'我的',
  ico:`<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
  <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z" />
</svg>
`
}];
</script>

<template>
  <div class="grid grid-cols-[1fr,5fr,2fr] gap-4">

<!--    选项栏-->
    <div class="gap-4">
      <div v-for="element in siderBar" class="cursor-pointer select-none flex hover:scale-110 active:scale-90 flex-nowrap text-black hover:text-blue-300 justify-center active:text-blue-500  rounded-xl mx-auto w-fit dark:text-white dark:hover:text-blue-300">
        <div v-html="element.ico"></div>
        <h1 class="font-kai text-xl">{{element.title}}</h1>
      </div>
    </div>

<!--    Blogs栏-->
    <div class="flex flex-wrap gap-4">
      <div v-if="themeStore.currentTheme ==='light'"  class="hover:scale-105 active:scale-100 clickEffect1 rounded-xl p-4 mx-auto bg-gray-100" v-for="blog in options.blogs" @click="blogClickHandle(blog.blog.id)">
        <h1 class="text-blue-500 font-kai">{{blog.blog.title}}</h1>
        <div class="grid grid-cols-[1fr,15fr]">
          <a-avatar shape="square" class="w-full h-auto" :src="blog.avator">
          </a-avatar>
          <h2 class="font-kai">{{blog.blog.content}}</h2>
        </div>
        <h3 class="text-blue-500 font-kai">{{blog.username}}</h3>
      </div>
      <div v-else class="hover:scale-105 active:scale-100 clickEffect1 rounded-xl p-4 mx-auto bg-gray-900" v-for="blog in options.blogs" @click="blogClickHandle(blog.blog.id)">
        <h1 class="text-blue-500">{{blog.blog.title}}</h1>
        <div class="grid grid-cols-[1fr,15fr]">
          <a-avatar shape="square" class="w-full h-auto" :src="blog.avator">
          </a-avatar>
          <h2>{{blog.blog.content}}</h2>
        </div>
        <h3 class="text-blue-500">{{blog.username}}</h3>
      </div>
    </div>

<!--    网络链接-->
    <div class="grid grid-rows-[1fr,10fr] gap-4">
      <div class=" font-kai flex flex-nowrap text-blue-300 mx-auto rounded-xl w-auto h-fit p-2 text-3xl cursor-pointer select-none bg-gray-100 dark:bg-gray-900 text-center">
        <span>网页链接</span>
        <button v-if="showForm===false" class=" rounded-full hover:scale-110 active:scale-90" @click="toggleForm">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-10 text-blue-300 hover:text-red-500">
            <path stroke-linecap="round" stroke-linejoin="round" d="m15 11.25-3-3m0 0-3 3m3-3v7.5M21 12a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
          </svg>
        </button>
        <button v-else class=" rounded-full hover:scale-110 active:scale-90" @click="toggleForm">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-10 text-blue-300 hover:text-red-500">
            <path stroke-linecap="round" stroke-linejoin="round" d="m11.25 9-3 3m0 0 3 3m-3-3h7.5M21 12a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
          </svg>
        </button>
      </div>
      <div v-if="showForm">
        <AddLinkForm />
      </div>
      <div v-else class="h-auto bg-gray-100 dark:bg-gray-900 rounded-xl">
        <div class="flex flex-wrap gap-4">
          <div v-if="themeStore.currentTheme ==='light'"  class="w-11/12 hover:scale-105 active:scale-100 clickEffect1 rounded-xl p-4 mx-auto bg-gray-100" v-for="links in option_link.links" >
            <a :href="links.location" target="_blank" class="text-blue-300 hover:text-red-500">{{links.name}}</a>
          </div>
          <div v-else class=" w-full hover:scale-105 active:scale-100 clickEffect1 hover:bg-blue-300 rounded-xl p-4 mx-auto bg-gray-900" v-for="links in option_link.links" >
            <a :href="links.location" target="_blank" class="text-blue-300 hover:text-red-500">{{links.name}}</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
</style>