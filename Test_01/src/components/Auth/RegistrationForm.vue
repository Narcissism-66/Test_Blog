<script setup>
import {reactive} from "vue";
import { ElMessage } from 'element-plus';
import {useThemeStore} from "@/stores/theme.js";
import router from "@/router/index.js";
// const props=defineProps(['isLoginComponent'])
const emits=defineEmits(['update:isLoginComponent']);
const goAnotherForm=()=>{
  router.push("/");
}
const themeStore=useThemeStore();
const loginform=reactive([
  {
    username:"",
    password:'',
  }
])

const loginHandler=()=>{
  if(loginform.username==='123'&&loginform.password==='123') {
    ElMessage.success("Hello~")
  }
  else {
    ElMessage.error("密码错误~")
  }
}

</script>

<script>

</script>

<template>
  <div class="themeStore.currentTheme==='light' min-h-screen flex items-center justify-center bg-gray-100">
    <div class="bg-blue-100 p-8 rounded-lg shadow-md w-96 text-blue-500">
      <h2 class="text-2xl font-semibold mb-6 text-center">注册</h2>
      <div >
        <div class="mb-4">
          <label for="username" class="block text-sm font-medium text-gray-700">用户名</label>
          <input
              type="text"
              id="username"
              v-model="loginform.username"
              class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
              placeholder="请输入用户名"
          />
        </div>
        <div class="mb-6">
          <label for="password" class="block text-sm font-medium text-gray-700">密码</label>
          <input
              type="password"
              id="password"
              v-model="loginform.password"
              class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
              placeholder="请输入密码"
          />
        </div>
        <button
            @click="loginHandler()"
            type="submit"
            class="w-full bg-indigo-600 text-white py-2 px-4 rounded-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
        >
          注册
        </button>
        <a class="select-none">已有账号</a>  <a @click="goAnotherForm" class="text-neutral-500 hover:text-blue-700 hover:underline cursor-pointer">马上登陆</a>
      </div>
    </div>
  </div>
</template>



<style scoped>
/* 你可以在这里添加一些自定义样式 */
</style>