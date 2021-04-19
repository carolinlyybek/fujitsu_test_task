<template>
    <a @click="scrollToBottom" class="scroller">
      To Feedback
      <v-icon>
        mdi-chevron-double-down
      </v-icon>
    </a>
</template>

<script>

export default {
  methods: {
    scrollToBottom() {
      window.scroll(0, document.body.scrollHeight)
    }
  }
}
</script>

<style scoped>
.scroller {
  cursor: pointer;
}
</style>
