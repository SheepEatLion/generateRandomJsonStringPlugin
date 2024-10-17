# generateRandomJsonStringPlugin
if you input keys from json. you can get Json String filled with Random values. (watch out the Format!)

insert your keys from json or java class etc. <br>
    this plugin fill the values automatically. <br>
    then you can get jsonString. <br>

    <h3>notice<h3>
    there is few rule you should follow.
    rule 1. insert format is [name, age, height, gender]
    rule 2. default setting is alphanumeric and length is 6.
    rule 3. if you customize length or letters, follow this example. [name*10, age*a, height*n3, gender*a20]
      - it starts with '*'. and a means alpha only. n means number only. you don't have to 'an' that's default option.
      - you can't insert like this [name*10a] or [lastOne,]. do not start with number. do not include comma for the end.

    hope you enjoy it.

----

키로 사용할 어떤 값이든 넣으세요.
자동으로 값을 채워서 키-값 구조의 문자열로 응답할 겁니다.

단, 규칙이 있습니다.

1. 콤마를 기준으로 키 값을 구분해야 해요. [name, age, height, gender]
2. 디폴트로 설정된 값생성 규칙은 알파벳+숫자, 6자제한이에요.
3. 이 제한들은 모두 커스터마이징 할 수 있어요.
   1. 키 값에 '*' 기호를 넣으면 제한 조건의 시작점으로 인식해요. [name*10, age*a, height*n3, gender*a20]
   2. a는 알파벳만 사용하겠다는 의미이고, n은 숫자만 사용하겠다는 의미에요. (디폴트가 둘 다 사용이니까 an 은 필요없어요.)
   3. 숫자는 길이 제한이에요. 최대 20자 까지만 가능해요.
   4. 단 알파벳 규칙과 길이제한을 모두 추가할 경우, 숫자가 먼저 오면 안돼요. a10 과 같이 알파벳이 먼저 와야 합니다.

enjoy!