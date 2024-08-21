# [Silver IV] 참가자 명단 - 23056 

[문제 링크](https://www.acmicpc.net/problem/23056) 

### 성능 요약

메모리: 11952 KB, 시간: 76 ms

### 분류

정렬

### 제출 일자

2024년 8월 21일 11:11:47

### 문제 설명

<p style="text-align: center; user-select: auto !important;"><img alt="" src="https://upload.acmicpc.net/a7fed846-80e3-4433-a3eb-c38604373f23/-/preview/" style="height: 500px; width: 500px; user-select: auto !important;"><br style="user-select: auto !important;">
 </p>

<p style="user-select: auto !important;">백남이의 모교인 백준고등학교에서 체육대회를 개최하려 한다.</p>

<p style="user-select: auto !important;">백남이는 학생들의 체육대회 신청을 관리하게 되었다.</p>

<p style="user-select: auto !important;">체육대회는 1부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative; user-select: auto !important;"><mjx-math class="MJX-TEX" aria-hidden="true" style="user-select: auto !important;"><mjx-mi class="mjx-i" style="user-select: auto !important;"><mjx-c class="mjx-c1D441 TEX-I" style="user-select: auto !important;"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline" style="user-select: auto !important;"><math xmlns="http://www.w3.org/1998/Math/MathML" style="user-select: auto !important;"><mi style="user-select: auto !important;">N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext" style="user-select: auto !important;">$N$</span></mjx-container>까지의 학급만 참여하며, 각 학급당 최대 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative; user-select: auto !important;"><mjx-math class="MJX-TEX" aria-hidden="true" style="user-select: auto !important;"><mjx-mi class="mjx-i" style="user-select: auto !important;"><mjx-c class="mjx-c1D440 TEX-I" style="user-select: auto !important;"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline" style="user-select: auto !important;"><math xmlns="http://www.w3.org/1998/Math/MathML" style="user-select: auto !important;"><mi style="user-select: auto !important;">M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext" style="user-select: auto !important;">$M$</span></mjx-container>명까지 선착순으로 참가할 수 있다. 단, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative; user-select: auto !important;"><mjx-math class="MJX-TEX" aria-hidden="true" style="user-select: auto !important;"><mjx-mi class="mjx-i" style="user-select: auto !important;"><mjx-c class="mjx-c1D441 TEX-I" style="user-select: auto !important;"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline" style="user-select: auto !important;"><math xmlns="http://www.w3.org/1998/Math/MathML" style="user-select: auto !important;"><mi style="user-select: auto !important;">N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext" style="user-select: auto !important;">$N$</span></mjx-container>은 짝수이다.</p>

<p style="user-select: auto !important;">또한, 체육대회의 팀을 학급이 홀수일 때 청팀, 짝수일 때 백팀으로 나누기로 했다.</p>

<p style="user-select: auto !important;">이에 따라 백남이는 체육대회 참가자 명단 프로그램을 제작하려 한다.</p>

<ul style="user-select: auto !important;">
	<li style="user-select: auto !important;">청팀을 먼저, 백팀을 나중에 출력한다.</li>
	<li style="user-select: auto !important;">각각의 팀에 대해 학급을 오름차순으로 출력한다.</li>
	<li style="user-select: auto !important;">각각의 학급에 대해 학생의 이름을 길이가 짧은 것부터, 길이가 같다면 사전 순으로 출력한다.</li>
</ul>

### 입력 

 <p style="user-select: auto !important;">첫째 줄에 학급 수인 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative; user-select: auto !important;"><mjx-math class="MJX-TEX" aria-hidden="true" style="user-select: auto !important;"><mjx-mi class="mjx-i" style="user-select: auto !important;"><mjx-c class="mjx-c1D441 TEX-I" style="user-select: auto !important;"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline" style="user-select: auto !important;"><math xmlns="http://www.w3.org/1998/Math/MathML" style="user-select: auto !important;"><mi style="user-select: auto !important;">N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext" style="user-select: auto !important;">$N$</span></mjx-container>과 학급당 신청 가능한 인원수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative; user-select: auto !important;"><mjx-math class="MJX-TEX" aria-hidden="true" style="user-select: auto !important;"><mjx-mi class="mjx-i" style="user-select: auto !important;"><mjx-c class="mjx-c1D440 TEX-I" style="user-select: auto !important;"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline" style="user-select: auto !important;"><math xmlns="http://www.w3.org/1998/Math/MathML" style="user-select: auto !important;"><mi style="user-select: auto !important;">M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext" style="user-select: auto !important;">$M$</span></mjx-container>이 주어진다. (<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative; user-select: auto !important;"><mjx-math class="MJX-TEX" aria-hidden="true" style="user-select: auto !important;"><mjx-mi class="mjx-i" style="user-select: auto !important;"><mjx-c class="mjx-c1D441 TEX-I" style="user-select: auto !important;"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline" style="user-select: auto !important;"><math xmlns="http://www.w3.org/1998/Math/MathML" style="user-select: auto !important;"><mi style="user-select: auto !important;">N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext" style="user-select: auto !important;">$N$</span></mjx-container>은 짝수이고 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative; user-select: auto !important;"><mjx-math class="MJX-TEX" aria-hidden="true" style="user-select: auto !important;"><mjx-mn class="mjx-n" style="user-select: auto !important;"><mjx-c class="mjx-c32" style="user-select: auto !important;"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4" style="user-select: auto !important;"><mjx-c class="mjx-c2264" style="user-select: auto !important;"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4" style="user-select: auto !important;"><mjx-c class="mjx-c1D441 TEX-I" style="user-select: auto !important;"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4" style="user-select: auto !important;"><mjx-c class="mjx-c2264" style="user-select: auto !important;"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4" style="user-select: auto !important;"><mjx-c class="mjx-c31" style="user-select: auto !important;"></mjx-c><mjx-c class="mjx-c30" style="user-select: auto !important;"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline" style="user-select: auto !important;"><math xmlns="http://www.w3.org/1998/Math/MathML" style="user-select: auto !important;"><mn style="user-select: auto !important;">2</mn><mo style="user-select: auto !important;">≤</mo><mi style="user-select: auto !important;">N</mi><mo style="user-select: auto !important;">≤</mo><mn style="user-select: auto !important;">10</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext" style="user-select: auto !important;">$2\leq N \leq 10$</span></mjx-container>, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative; user-select: auto !important;"><mjx-math class="MJX-TEX" aria-hidden="true" style="user-select: auto !important;"><mjx-mn class="mjx-n" style="user-select: auto !important;"><mjx-c class="mjx-c31" style="user-select: auto !important;"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4" style="user-select: auto !important;"><mjx-c class="mjx-c2264" style="user-select: auto !important;"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4" style="user-select: auto !important;"><mjx-c class="mjx-c1D440 TEX-I" style="user-select: auto !important;"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4" style="user-select: auto !important;"><mjx-c class="mjx-c2264" style="user-select: auto !important;"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4" style="user-select: auto !important;"><mjx-c class="mjx-c31" style="user-select: auto !important;"></mjx-c><mjx-c class="mjx-c30" style="user-select: auto !important;"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline" style="user-select: auto !important;"><math xmlns="http://www.w3.org/1998/Math/MathML" style="user-select: auto !important;"><mn style="user-select: auto !important;">1</mn><mo style="user-select: auto !important;">≤</mo><mi style="user-select: auto !important;">M</mi><mo style="user-select: auto !important;">≤</mo><mn style="user-select: auto !important;">10</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext" style="user-select: auto !important;">$1\leq M \leq 10$</span></mjx-container>)</p>

<p style="user-select: auto !important;">둘째 줄부터 신청된 순서대로 학생의 학급과 이름이 주어진다. 학생의 학급은 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative; user-select: auto !important;"><mjx-math class="MJX-TEX" aria-hidden="true" style="user-select: auto !important;"><mjx-mi class="mjx-i" style="user-select: auto !important;"><mjx-c class="mjx-c1D441 TEX-I" style="user-select: auto !important;"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline" style="user-select: auto !important;"><math xmlns="http://www.w3.org/1998/Math/MathML" style="user-select: auto !important;"><mi style="user-select: auto !important;">N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext" style="user-select: auto !important;">$N$</span></mjx-container>을 초과하지 않는다. 이름은 모두 소문자이며 15자를 초과하지 않는다.</p>

<p style="user-select: auto !important;">학급과 이름이 동일한 학생은 존재하지 않는다.</p>

<p style="user-select: auto !important;">신청할 수 있는 최대 학생 수는 500명이다.</p>

<p style="user-select: auto !important;">입력의 마지막은 0 0으로 나타낸다.</p>

### 출력 

 <p style="user-select: auto !important;">첫째 줄부터 백남이의 체육대회 참가자 명단 프로그램에 맞게 학생의 학급과 이름을 공백으로 구분하여 출력한다.</p>

