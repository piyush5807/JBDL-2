package com.example.Spring3.dto;

import java.util.List;

class GitHubResponse<T> {
    private List<T> items;

    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }
}
