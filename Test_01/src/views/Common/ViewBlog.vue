<script setup>
import {onMounted, reactive, ref} from 'vue';
import { MdPreview, MdCatalog } from 'md-editor-v3';
import 'md-editor-v3/lib/preview.css';
import {useThemeStore} from "@/stores/theme.js";
import {message} from "ant-design-vue";
import {data} from "autoprefixer";
import {get} from "@/net/index.js";
import {useRoute} from "vue-router";
import {parseDateTime} from "@/util/DateFormattor.js";

const route=useRoute();
const pid=route.params.id;
const id = 'preview-only';
const options=reactive({
  data:{
    blog:{
      content:"",
      title:"",
    }
  }
})
const text = ref('# Hello Editor');
const scrollElement = document.documentElement;
const themeStore=useThemeStore();
const fetchBlogContent=()=>{
  get('api/blog/getBlog',
      {id:pid},
      (message,data)=>{
        options.data=data;
      })
}
onMounted(()=>{
  fetchBlogContent();
})
</script>

<template>
  <div class="flex h-screen ">
    <!-- 目录导航栏 -->
    <aside class="w-1/6  text-white  p-5">
      <MdCatalog :theme="themeStore.currentTheme" :editorId="id" :scrollElement="scrollElement" class="font-kai" />
      <!-- 导航栏内容可以放在这里 -->
    </aside>

    <!-- 主内容区域 -->
    <main class="w-full font-kai">
      <!-- 主内容可以放在这里 -->
      <h1 class="text-blue-300 font-bold rounded-xl w-fit h-auto p-2  text-4xl cursor-pointer select-none">标题：{{options.data.blog.title}}</h1>
      <div class="flex flex-nowrap gap-4">
        <h1 class=" font-bold rounded-xl w-fit h-auto  text-xl text-red-500 cursor-pointer select-none">
          作者：{{options.data.username}}</h1>
        <h1 class=" font-bold rounded-xl w-fit h-auto text-xl  text-blue-300 cursor-pointer select-none">
          修改时间：{{parseDateTime(options.data.blog.updateDate)}}</h1>
        <span class="select-none text-xl cursor-pointer" :class="options.data.blog.isPublic === 0 ? 'text-green-600':'text-green-600'">
          查看权限：{{options.data.blog.isPublic === 0 ? '公开':'私密'}}</span>
      </div>


      <div class="flex font-normal gap-4">
        <button>
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6 text-blue-300">
            <path stroke-linecap="round" stroke-linejoin="round" d="M6.633 10.25c.806 0 1.533-.446 2.031-1.08a9.041 9.041 0 0 1 2.861-2.4c.723-.384 1.35-.956 1.653-1.715a4.498 4.498 0 0 0 .322-1.672V2.75a.75.75 0 0 1 .75-.75 2.25 2.25 0 0 1 2.25 2.25c0 1.152-.26 2.243-.723 3.218-.266.558.107 1.282.725 1.282m0 0h3.126c1.026 0 1.945.694 2.054 1.715.045.422.068.85.068 1.285a11.95 11.95 0 0 1-2.649 7.521c-.388.482-.987.729-1.605.729H13.48c-.483 0-.964-.078-1.423-.23l-3.114-1.04a4.501 4.501 0 0 0-1.423-.23H5.904m10.598-9.75H14.25M5.904 18.5c.083.205.173.405.27.602.197.4-.078.898-.523.898h-.908c-.889 0-1.713-.518-1.972-1.368a12 12 0 0 1-.521-3.507c0-1.553.295-3.036.831-4.398C3.387 9.953 4.167 9.5 5 9.5h1.053c.472 0 .745.556.5.96a8.958 8.958 0 0 0-1.302 4.665c0 1.194.232 2.333.654 3.375Z" />
          </svg>
        </button>
        <div class="text-xl text-blue-300">{{options.data.blog.likes}}</div>
        <button>
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6 text-blue-300">
            <path stroke-linecap="round" stroke-linejoin="round" d="M2.036 12.322a1.012 1.012 0 0 1 0-.639C3.423 7.51 7.36 4.5 12 4.5c4.638 0 8.573 3.007 9.963 7.178.07.207.07.431 0 .639C20.577 16.49 16.64 19.5 12 19.5c-4.638 0-8.573-3.007-9.963-7.178Z" />
            <path stroke-linecap="round" stroke-linejoin="round" d="M15 12a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z" />
          </svg>
        </button>
        <div class="text-xl text-blue-300">{{options.data.blog.watches}}</div>
        <button>
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6 text-blue-300 ">
            <path stroke-linecap="round" stroke-linejoin="round" d="M11.48 3.499a.562.562 0 0 1 1.04 0l2.125 5.111a.563.563 0 0 0 .475.345l5.518.442c.499.04.701.663.321.988l-4.204 3.602a.563.563 0 0 0-.182.557l1.285 5.385a.562.562 0 0 1-.84.61l-4.725-2.885a.562.562 0 0 0-.586 0L6.982 20.54a.562.562 0 0 1-.84-.61l1.285-5.386a.562.562 0 0 0-.182-.557l-4.204-3.602a.562.562 0 0 1 .321-.988l5.518-.442a.563.563 0 0 0 .475-.345L11.48 3.5Z" />
          </svg>
        </button>
        <div class="text-xl text-blue-300">{{options.data.blog.favourites}}</div>
        <div v-if="options.data.blog.isPublic !== 0">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6 text-blue-300">
            <path stroke-linecap="round" stroke-linejoin="round" d="M16.5 10.5V6.75a4.5 4.5 0 1 0-9 0v3.75m-.75 11.25h10.5a2.25 2.25 0 0 0 2.25-2.25v-6.75a2.25 2.25 0 0 0-2.25-2.25H6.75a2.25 2.25 0 0 0-2.25 2.25v6.75a2.25 2.25 0 0 0 2.25 2.25Z" />
          </svg>
        </div>
        <div v-else>
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6 text-blue-300">
            <path stroke-linecap="round" stroke-linejoin="round" d="M13.5 10.5V6.75a4.5 4.5 0 1 1 9 0v3.75M3.75 21.75h10.5a2.25 2.25 0 0 0 2.25-2.25v-6.75a2.25 2.25 0 0 0-2.25-2.25H3.75a2.25 2.25 0 0 0-2.25 2.25v6.75a2.25 2.25 0 0 0 2.25 2.25Z" />
          </svg>
        </div>
      </div>
      <MdPreview :theme="themeStore.currentTheme" :editorId="id" :modelValue="options.data.blog.content" />
    </main>
  </div>
</template>

