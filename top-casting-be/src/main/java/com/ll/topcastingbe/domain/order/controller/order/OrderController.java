package com.ll.topcastingbe.domain.order.controller.order;


import com.ll.topcastingbe.domain.member.entity.Member;
import com.ll.topcastingbe.domain.member.service.MemberService;
import com.ll.topcastingbe.domain.order.dto.order.AddOrderDto;
import com.ll.topcastingbe.domain.order.dto.order.AddOrderResponseDto;
import com.ll.topcastingbe.domain.order.service.order.OrderService;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;

    @PostAuthorize("isAuthenticated()")
    @PostMapping("/order")
    public ResponseEntity<AddOrderResponseDto> orderAdd(@Valid @RequestBody final AddOrderDto addOrderDto,
                                                        @AuthenticationPrincipal final UserDetails userDetails) {
        final Member member = memberService.findMember(userDetails.getUsername());
        final AddOrderResponseDto addOrderResponseDto =
                AddOrderResponseDto.of(orderService.addOrder(addOrderDto.toAddOrderRequest(), member));

        return ResponseEntity.created(URI.create(""))
                .header("Location", "")
                .body(addOrderResponseDto);
    }

}
