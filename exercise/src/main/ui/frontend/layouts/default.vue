<template>
  <v-app>
      <v-app-bar
      fixed
      color="white"
      elevate-on-scroll
      >
        <v-toolbar-title>Fujitsu Test Task</v-toolbar-title>
        <v-spacer />
        <Scroll />
      </v-app-bar>

      <v-main class = "mt-8">
        <nuxt/>
      </v-main>

      <v-footer
      color="white"
      elevation="1"
      height="50px"
      shaped
      >
        <v-row justify="center">
          <v-icon>
            mdi-copyright
          </v-icon>
          By Carolin Lüübek, {{ new Date().getFullYear() }}
        </v-row>
      </v-footer>
  </v-app>
</template>

<script>
import Scroll from '@/components/Scroll.vue'
export default {
  components: {
    Scroll
  }
}
</script>
