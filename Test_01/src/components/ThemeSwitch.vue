
<script setup>
import {useThemeStore} from "@/stores/theme.js";
import router from "@/router/index.js";

const themeStore=useThemeStore();

const toggleThemeHandler=()=>{
  themeStore.toggleTheme();
}
</script>

<template>

  <button v-if="themeStore.currentTheme==='light'" class="hover:scale-110  active:scale-90 bg-[#fe785a] flex flex-nowrap p-1 rounded-xl hover:bg-red-500 active:bg-red-600 " @click="router.push('/edit')">
    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-5">
      <path stroke-linecap="round" stroke-linejoin="round" d="M12 9v6m3-3H9m12 0a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
    </svg>
    <span class="font-bold font-kai ">发布</span>
  </button >
  <button v-else class="hover:scale-110  active:scale-90 bg-blue-300 flex flex-nowrap p-1 rounded-xl hover:bg-blue-500 active:bg-blue-700 " @click="router.push('/edit')">
    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-5">
      <path stroke-linecap="round" stroke-linejoin="round" d="M12 9v6m3-3H9m12 0a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
    </svg>
    <span class="font-bold font-kai">发布</span>
  </button>

  <button class="bg-blue-300 rounded-xl p-0.5 hover:scale-110  active:scale-90" @click="toggleThemeHandler()">
    <svg v-if="themeStore.currentTheme==='light'" xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6 text-white">
      <path stroke-linecap="round" stroke-linejoin="round" d="M12 3v2.25m6.364.386-1.591 1.591M21 12h-2.25m-.386 6.364-1.591-1.591M12 18.75V21m-4.773-4.227-1.591 1.591M5.25 12H3m4.227-4.773L5.636 5.636M15.75 12a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0Z" />
    </svg>
    <svg v-else xmlns="http://www.w3.org/2000/svg" fill="#FFFFFF" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
      <path stroke-linecap="round" stroke-linejoin="round" d="M21.752 15.002A9.72 9.72 0 0 1 18 15.75c-5.385 0-9.75-4.365-9.75-9.75 0-1.33.266-2.597.748-3.752A9.753 9.753 0 0 0 3 11.25C3 16.635 7.365 21 12.75 21a9.753 9.753 0 0 0 9.002-5.998Z" />
    </svg>
  </button>

  <!--  退出-->
  <button class="hover:scale-110  active:scale-90">
    <svg v-if="themeStore.currentTheme==='light'" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6 text-black hover:text-blue-500  active:scale-90" @click="router.push('/auth')">
      <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 9V5.25A2.25 2.25 0 0 0 13.5 3h-6a2.25 2.25 0 0 0-2.25 2.25v13.5A2.25 2.25 0 0 0 7.5 21h6a2.25 2.25 0 0 0 2.25-2.25V15m3 0 3-3m0 0-3-3m3 3H9" />
    </svg>
    <svg v-else xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6 hover:text-blue-500  active:scale-90" @click="router.push('/')">
      <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 9V5.25A2.25 2.25 0 0 0 13.5 3h-6a2.25 2.25 0 0 0-2.25 2.25v13.5A2.25 2.25 0 0 0 7.5 21h6a2.25 2.25 0 0 0 2.25-2.25V15m3 0 3-3m0 0-3-3m3 3H9" />
    </svg>
  </button>


</template>