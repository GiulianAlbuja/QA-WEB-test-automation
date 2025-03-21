Feature: Product - Store
  @loginMyStore
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<usuario>" y clave "<clave>"
    When navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    And agrego <unidades> unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
    Examples:
    |usuario|clave|categoria|subcategoria|unidades|
    |david-albuja-201@hotmail.com|quedivertidapelicula|CLOTHES|Men|10|
    |david123|pelicula|Clothes|Men|2|
    |david-albuja-201@hotmail.com|quedivertidapelicula|Autos|Men|2|