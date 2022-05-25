package com.example.springdemo.dto.paginateddto;

import com.example.springdemo.dto.responsedto.PostResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedPostResponseDto {
    private List<PostResponseDto> list;
    private long dataCount;
}
