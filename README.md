# :leaves: Spring_Boot B
SSUMC 7기 Spring Boot 스터디 B조

## 💻 Member
| 김민석 | 류장원 | 이가은 | 이호근 |
| :---------:|:----------:|:----------:|:----------:|
| 빙석 | 랜디 | 누누 | 우디 |
| [bingseok](https://github.com/bingseok) | [Jangwon0319](https://github.com/Jangwon0319) | [Ssamssamukja](https://github.com/Ssamssamukja) | [2ghrms](https://github.com/2ghrms) |

## 📁 디렉토리 구조
```bash
├─.github
│  └─PULL_REQUEST_TEMPLATE
│  └─ISSUE_TEMPLATE
├─README.md
├─docs
│  └─chapter1
            Ch01Keyword.md
            Ch01Keyword.txt
└─src
    ├─mission
    │  └─chapter1
    └─practice
        └─chapter1
``` 

## 🌳 branch 규칙
```bash
├─main
    ├─ls-rain/main
    │  └─ls-rain/#1
``` 

1. `닉네임/main 브랜치`가 기본 브랜치로 pr 보낼 때 root 브랜치(main 브랜치)가 아닌 닉네임/main 브랜치로 올립니다.
2. 매주 워크북, 실습, 그리고 미션은 각자의 닉네임/main 브랜치를 base 브랜치로 삼아 `닉네임/이슈번호 브랜치`를 생성하여 관련 파일을 업로드합니다.
3. 모든 팀원들의 approve를 받으면, pr을 머지하고 해당 pr을 생성한 브랜치(닉네임/이슈번호 브랜치)는 삭제합니다. approve와 merge는 스터디 진행 중에 이루어집니다.

## 🔖 커밋 컨벤션
| Message  | 설명                                              |
| :------: | :------------------------------------------------ |
|   mission   | 미션 수행                                  |
|   practice   | 실습 수행                             |
|   keyword    | 키워드 정리                                         |
|   workbook   | 워크북 정리                                         |
|  fix   | 버그 수정 |
| docs | 문서 수정                                     |
| comment | 주석 추가 및 변경                                     |
|   test   | 테스트 코드 추가                                       |
|  rename   | 파일 혹은 폴더명 수정                |
|  remove   | 파일 혹은 폴더 삭제                |
|  chore   | 기타 변경사항                |
