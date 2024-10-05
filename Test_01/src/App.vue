<script setup>
import { RouterLink, RouterView } from 'vue-router'
import {useThemeStore} from "@/stores/theme.js";
const themeStore=useThemeStore();
themeStore.initTheme();
</script>

<template>
    <RouterView />
</template>

